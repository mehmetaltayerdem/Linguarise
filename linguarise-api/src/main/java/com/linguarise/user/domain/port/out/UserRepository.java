package com.linguarise.user.domain.port.out;

import com.linguarise.user.domain.model.User;

import java.util.Optional;

/**
 * Output port for User persistence.
 * Implemented by JpaUserRepository in infrastructure layer.
 */
public interface UserRepository {

    Optional<User> findByKeycloakId(String keycloakId);

    Optional<User> findByEmail(String email);

    Optional<User> findById(Long id);

    User save(User user);

    boolean existsByKeycloakId(String keycloakId);
}
