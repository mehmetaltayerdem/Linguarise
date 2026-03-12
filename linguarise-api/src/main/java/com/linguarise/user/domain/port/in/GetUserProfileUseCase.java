package com.linguarise.user.domain.port.in;

import com.linguarise.user.domain.model.User;

/**
 * Input port for retrieving user profile.
 */
public interface GetUserProfileUseCase {

    User getByKeycloakId(String keycloakId);
}
