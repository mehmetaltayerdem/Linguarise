package com.linguarise.user.domain.port.in;

import com.linguarise.user.domain.model.UserPreferences;

public interface GetUserPreferencesUseCase {
    UserPreferences getOrCreate(String keycloakId);
}