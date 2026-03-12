package com.linguarise.user.application.service;

import com.linguarise.shared.exception.ResourceNotFoundException;
import com.linguarise.user.application.dto.UpdateProfileRequest;
import com.linguarise.user.domain.model.User;
import com.linguarise.user.domain.port.in.UpdateProfileUseCase;
import com.linguarise.user.domain.port.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdateProfileService implements UpdateProfileUseCase {

    private final UserRepository userRepository;

    @Override
    public User updateProfile(String keycloakId, UpdateProfileRequest request) {
        User user = userRepository.findByKeycloakId(keycloakId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "keycloakId", keycloakId));

        user.updateProfile(
                request.displayName(),
                request.learningGoal(),
                request.targetExam(),
                request.yokdilDomain()
        );

        return userRepository.save(user);
    }
}
