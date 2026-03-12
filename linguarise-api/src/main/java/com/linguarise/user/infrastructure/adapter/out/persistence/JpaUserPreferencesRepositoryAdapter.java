package com.linguarise.user.infrastructure.adapter.out.persistence;

import com.linguarise.user.domain.model.UserPreferences;
import com.linguarise.user.domain.port.out.UserPreferencesRepository;
import com.linguarise.user.infrastructure.mapper.UserPreferencesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaUserPreferencesRepositoryAdapter implements UserPreferencesRepository {

    private final SpringDataUserPreferencesRepository jpaRepository;
    private final UserPreferencesMapper mapper;

    @Override
    public Optional<UserPreferences> findByUserId(Long userId) {
        return jpaRepository.findByUserId(userId).map(mapper::toDomain);
    }

    @Override
    public UserPreferences save(UserPreferences preferences) {
        var entity = mapper.toEntity(preferences);
        var saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }
}