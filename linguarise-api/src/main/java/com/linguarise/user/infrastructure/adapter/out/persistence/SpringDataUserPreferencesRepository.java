package com.linguarise.user.infrastructure.adapter.out.persistence;

import com.linguarise.user.infrastructure.entity.UserPreferencesJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataUserPreferencesRepository extends JpaRepository<UserPreferencesJpaEntity, Long> {
    Optional<UserPreferencesJpaEntity> findByUserId(Long userId);
}