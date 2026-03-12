package com.linguarise.user.application.service;

import com.linguarise.user.domain.model.User;
import com.linguarise.user.domain.port.in.RegisterUserUseCase;
import com.linguarise.user.domain.port.out.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class RegisterUserService implements RegisterUserUseCase {

    private final UserRepository userRepository;

    @Override
    public User registerOrGet(String keycloakId, String email, String displayName) {
        return userRepository.findByKeycloakId(keycloakId)
                .orElseGet(() -> {
                    log.info("Registering new user: {} ({})", displayName, email);
                    User newUser = User.create(keycloakId, email, displayName);
                    return userRepository.save(newUser);
                });
    }
}
