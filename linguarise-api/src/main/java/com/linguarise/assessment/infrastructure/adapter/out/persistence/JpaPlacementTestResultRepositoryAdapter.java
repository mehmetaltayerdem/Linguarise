package com.linguarise.assessment.infrastructure.adapter.out.persistence;

import com.linguarise.assessment.domain.model.PlacementTestResult;
import com.linguarise.assessment.domain.port.out.PlacementTestResultRepository;
import com.linguarise.assessment.infrastructure.entity.PlacementTestResultJpaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaPlacementTestResultRepositoryAdapter implements PlacementTestResultRepository {

    private final SpringDataPlacementTestResultRepository jpaRepository;

    @Override
    public PlacementTestResult save(PlacementTestResult result) {
        PlacementTestResultJpaEntity entity = PlacementTestResultJpaEntity.builder()
                .id(result.getId())
                .userId(result.getUserId())
                .score(result.getScore())
                .totalQuestions(result.getTotalQuestions())
                .cefrLevel(result.getCefrLevel())
                .startedAt(result.getStartedAt())
                .completedAt(result.getCompletedAt())
                .answersJson(result.getAnswers())
                .build();

        PlacementTestResultJpaEntity saved = jpaRepository.save(entity);

        return toDomain(saved);
    }

    @Override
    public Optional<PlacementTestResult> findLatestByUserId(Long userId) {
        return jpaRepository.findFirstByUserIdOrderByCompletedAtDesc(userId).map(this::toDomain);
    }

    @Override
    public List<PlacementTestResult> findAllByUserId(Long userId) {
        return jpaRepository.findAllByUserIdOrderByCompletedAtDesc(userId)
                .stream()
                .map(this::toDomain)
                .toList();
    }

    private PlacementTestResult toDomain(PlacementTestResultJpaEntity entity) {
        PlacementTestResult result = new PlacementTestResult();
        result.setId(entity.getId());
        result.setUserId(entity.getUserId());
        result.setScore(entity.getScore());
        result.setTotalQuestions(entity.getTotalQuestions());
        result.setCefrLevel(entity.getCefrLevel());
        result.setStartedAt(entity.getStartedAt());
        result.setCompletedAt(entity.getCompletedAt());
        result.setAnswers(entity.getAnswersJson());
        return result;
    }
}