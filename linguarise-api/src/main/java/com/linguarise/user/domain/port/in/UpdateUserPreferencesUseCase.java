package com.linguarise.user.domain.port.in;

import com.linguarise.user.application.dto.UserPreferencesRequest;
import com.linguarise.user.domain.model.UserPreferences;

public interface UpdateUserPreferencesUseCase {
    UserPreferences update(String keycloakId, UserPreferencesRequest request);
}