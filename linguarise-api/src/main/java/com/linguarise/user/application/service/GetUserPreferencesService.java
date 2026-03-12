package com.linguarise.user.application.service;

import com.linguarise.shared.exception.ResourceNotFoundException;
import com.linguarise.user.domain.model.User;
import com.linguarise.user.domain.model.UserPreferences;
import com.linguarise.user.domain.port.in.GetUserPreferencesUseCase;
import com.linguarise.user.domain.port.out.UserPreferencesRepository;
import com.linguarise.user.domain.port.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class GetUserPreferencesService implements GetUserPreferencesUseCase {

    private final UserRepository userRepository;
    private final UserPreferencesRepository userPreferencesRepository;

    @Override
    public UserPreferences getOrCreate(String keycloakId) {
        User user = userRepository.findByKeycloakId(keycloakId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "keycloakId", keycloakId));

        return userPreferencesRepository.findByUserId(user.getId())
                .orElseGet(() -> userPreferencesRepository.save(UserPreferences.createDefault(user.getId())));
    }
}