package com.linguarise.user.domain.port.out;

import com.linguarise.user.domain.model.UserPreferences;

import java.util.Optional;

public interface UserPreferencesRepository {
    Optional<UserPreferences> findByUserId(Long userId);
    UserPreferences save(UserPreferences preferences);
}