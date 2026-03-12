package com.linguarise.user.domain.port.in;

import com.linguarise.user.application.dto.UpdateProfileRequest;
import com.linguarise.user.domain.model.User;

public interface UpdateProfileUseCase {
    User updateProfile(String keycloakId, UpdateProfileRequest request);
}
