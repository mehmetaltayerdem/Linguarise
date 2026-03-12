package com.linguarise.user.domain.port.in;

import com.linguarise.user.domain.model.User;

public interface RegisterUserUseCase {
    User registerOrGet(String keycloakId, String email, String displayName);
}
