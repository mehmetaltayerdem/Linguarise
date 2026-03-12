package com.linguarise.user.application.service;

import com.linguarise.shared.exception.ResourceNotFoundException;
import com.linguarise.user.application.dto.UserPreferencesRequest;
import com.linguarise.user.domain.model.User;
import com.linguarise.user.domain.model.UserPreferences;
import com.linguarise.user.domain.port.in.UpdateUserPreferencesUseCase;
import com.linguarise.user.domain.port.out.UserPreferencesRepository;
import com.linguarise.user.domain.port.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdateUserPreferencesService implements UpdateUserPreferencesUseCase {

    private final UserRepository userRepository;
    private final UserPreferencesRepository userPreferencesRepository;

    @Override
    public UserPreferences update(String keycloakId, UserPreferencesRequest request) {
        User user = userRepository.findByKeycloakId(keycloakId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "keycloakId", keycloakId));

        UserPreferences preferences = userPreferencesRepository.findByUserId(user.getId())
                .orElseGet(() -> UserPreferences.createDefault(user.getId()));

        preferences.update(
                request.dailyWordGoal(),
                request.dailyReadingGoal(),
                request.dailyQuizGoal(),
                request.dailyReviewGoal(),
                request.interests(),
                request.notificationEnabled()
        );

        return userPreferencesRepository.save(preferences);
    }
}