package com.linguarise.assessment.application.service;

import com.linguarise.assessment.application.dto.SubmitPlacementTestRequest;
import com.linguarise.assessment.application.dto.SubmitPlacementTestResponse;
import com.linguarise.assessment.domain.model.PlacementQuestion;
import com.linguarise.assessment.domain.model.PlacementTestResult;
import com.linguarise.assessment.domain.model.PlacementTestSession;
import com.linguarise.assessment.domain.port.in.SubmitTestUseCase;
import com.linguarise.assessment.domain.port.out.CooldownStore;
import com.linguarise.assessment.domain.port.out.PlacementQuestionRepository;
import com.linguarise.assessment.domain.port.out.PlacementTestResultRepository;
import com.linguarise.assessment.domain.port.out.PlacementTestSessionStore;
import com.linguarise.assessment.domain.service.LevelDeterminer;
import com.linguarise.assessment.domain.service.ScoreCalculator;
import com.linguarise.shared.domain.CEFRLevel;
import com.linguarise.shared.exception.BusinessRuleException;
import com.linguarise.shared.exception.ResourceNotFoundException;
import com.linguarise.user.domain.model.User;
import com.linguarise.user.domain.port.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SubmitTestService implements SubmitTestUseCase {

    private final UserRepository userRepository;
    private final PlacementQuestionRepository placementQuestionRepository;
    private final PlacementTestResultRepository placementTestResultRepository;
    private final PlacementTestSessionStore placementTestSessionStore;
    private final ScoreCalculator scoreCalculator;
    private final LevelDeterminer levelDeterminer;
    private final CooldownStore cooldownStore;

    @Override
    public SubmitPlacementTestResponse submit(String keycloakId, String testId, SubmitPlacementTestRequest request) {
        User user = userRepository.findByKeycloakId(keycloakId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "keycloakId", keycloakId));

        PlacementTestSession session = placementTestSessionStore.findByTestId(testId)
                .orElseThrow(() -> new BusinessRuleException("Geçerli bir placement test oturumu bulunamadı."));

        if (!session.userId().equals(user.getId())) {
            throw new BusinessRuleException("Bu test oturumu kullanıcıya ait değil.");
        }

        List<PlacementQuestion> questions = placementQuestionRepository.findAllPlacementQuestions();

        int score = scoreCalculator.calculateScore(questions, request.answers());
        int totalQuestions = scoreCalculator.totalQuestions(questions);
        CEFRLevel level = levelDeterminer.determine(score, totalQuestions);

        PlacementTestResult result = PlacementTestResult.create(
                user.getId(),
                score,
                totalQuestions,
                level,
                session.startedAt(),
                LocalDateTime.now(),
                request.answers()
        );

        PlacementTestResult saved = placementTestResultRepository.save(result);

        user.setCefrLevel(level);
        userRepository.save(user);

        cooldownStore.putCooldown(user.getId(), Duration.ofDays(14));
        placementTestSessionStore.delete(testId);

        return new SubmitPlacementTestResponse(
                saved.getId(),
                saved.getScore(),
                saved.getTotalQuestions(),
                saved.getCefrLevel()
        );
    }
}