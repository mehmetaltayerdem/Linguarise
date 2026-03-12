package com.linguarise.user.application.service;

import com.linguarise.shared.exception.ResourceNotFoundException;
import com.linguarise.user.domain.model.User;
import com.linguarise.user.domain.port.in.GetUserProfileUseCase;
import com.linguarise.user.domain.port.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetUserProfileService implements GetUserProfileUseCase {

    private final UserRepository userRepository;

    @Override
    public User getByKeycloakId(String keycloakId) {
        return userRepository.findByKeycloakId(keycloakId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "keycloakId", keycloakId));
    }
}
