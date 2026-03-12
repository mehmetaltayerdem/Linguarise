package com.linguarise.user.infrastructure.adapter.out.persistence;

import com.linguarise.user.infrastructure.entity.UserJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SpringDataUserRepository extends JpaRepository<UserJpaEntity, Long> {
    Optional<UserJpaEntity> findByKeycloakId(String keycloakId);
    Optional<UserJpaEntity> findByEmail(String email);
    boolean existsByKeycloakId(String keycloakId);
}
