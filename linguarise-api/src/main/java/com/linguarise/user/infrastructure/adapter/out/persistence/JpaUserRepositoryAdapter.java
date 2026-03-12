package com.linguarise.user.infrastructure.adapter.out.persistence;

import com.linguarise.user.domain.model.User;
import com.linguarise.user.domain.port.out.UserRepository;
import com.linguarise.user.infrastructure.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaUserRepositoryAdapter implements UserRepository {

    private final SpringDataUserRepository jpaRepository;
    private final UserMapper userMapper;

    @Override
    public Optional<User> findByKeycloakId(String keycloakId) {
        return jpaRepository.findByKeycloakId(keycloakId).map(userMapper::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaRepository.findByEmail(email).map(userMapper::toDomain);
    }

    @Override
    public Optional<User> findById(Long id) {
        return jpaRepository.findById(id).map(userMapper::toDomain);
    }

    @Override
    public User save(User user) {
        var entity = userMapper.toEntity(user);
        var saved = jpaRepository.save(entity);
        return userMapper.toDomain(saved);
    }

    @Override
    public boolean existsByKeycloakId(String keycloakId) {
        return jpaRepository.existsByKeycloakId(keycloakId);
    }
}
