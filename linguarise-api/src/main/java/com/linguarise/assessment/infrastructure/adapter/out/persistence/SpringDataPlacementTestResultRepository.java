package com.linguarise.assessment.infrastructure.adapter.out.persistence;

import com.linguarise.assessment.infrastructure.entity.PlacementTestResultJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataPlacementTestResultRepository
        extends JpaRepository<PlacementTestResultJpaEntity, Long> {

    Optional<PlacementTestResultJpaEntity> findFirstByUserIdOrderByCompletedAtDesc(Long userId);

    List<PlacementTestResultJpaEntity> findAllByUserIdOrderByCompletedAtDesc(Long userId);
}