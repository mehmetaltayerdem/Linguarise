package com.linguarise.assessment.application.service;

import com.linguarise.assessment.application.dto.PlacementQuestionResponse;
import com.linguarise.assessment.application.dto.StartPlacementTestResponse;
import com.linguarise.assessment.domain.model.PlacementQuestion;
import com.linguarise.assessment.domain.model.PlacementTestSession;
import com.linguarise.assessment.domain.port.in.StartTestUseCase;
import com.linguarise.assessment.domain.port.out.CooldownStore;
import com.linguarise.assessment.domain.port.out.PlacementQuestionRepository;
import com.linguarise.assessment.domain.port.out.PlacementTestSessionStore;
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
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StartTestService implements StartTestUseCase {

    private final UserRepository userRepository;
    private final PlacementQuestionRepository placementQuestionRepository;
    private final CooldownStore cooldownStore;
    private final PlacementTestSessionStore placementTestSessionStore;

    @Override
    public StartPlacementTestResponse start(String keycloakId) {
        User user = userRepository.findByKeycloakId(keycloakId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "keycloakId", keycloakId));

        if (cooldownStore.hasCooldown(user.getId())) {
            throw new BusinessRuleException("Placement test için cooldown devam ediyor.");
        }

        List<PlacementQuestion> questions = placementQuestionRepository.findAllPlacementQuestions();

        if (questions.isEmpty()) {
            throw new BusinessRuleException("Placement soruları bulunamadı.");
        }

        String testId = UUID.randomUUID().toString();
        LocalDateTime startedAt = LocalDateTime.now();

        placementTestSessionStore.save(
                new PlacementTestSession(testId, user.getId(), startedAt),
                Duration.ofHours(2)
        );

        List<PlacementQuestionResponse> responseQuestions = questions.stream()
                .map(q -> new PlacementQuestionResponse(
                        q.getId(),
                        q.getQuestionType(),
                        q.getCategory(),
                        q.getQuestion(),
                        q.getOptions(),
                        q.getOrderNo()
                ))
                .toList();

        return new StartPlacementTestResponse(
                testId,
                startedAt,
                responseQuestions.size(),
                responseQuestions
        );
    }
}