package com.linguarise.user.infrastructure.adapter.in.web;

import com.linguarise.user.application.dto.UpdateProfileRequest;
import com.linguarise.user.application.dto.UserProfileResponse;
import com.linguarise.user.domain.model.User;
import com.linguarise.user.domain.port.in.GetUserProfileUseCase;
import com.linguarise.user.domain.port.in.RegisterUserUseCase;
import com.linguarise.user.domain.port.in.UpdateProfileUseCase;
import com.linguarise.user.infrastructure.mapper.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "Users", description = "User profile management")
@SecurityRequirement(name = "Bearer Authentication")
public class UserController {

    private final GetUserProfileUseCase getUserProfileUseCase;
    private final UpdateProfileUseCase updateProfileUseCase;
    private final RegisterUserUseCase registerUserUseCase;
    private final UserMapper userMapper;

    @GetMapping("/me")
    @Operation(summary = "Get current user profile")
    public ResponseEntity<UserProfileResponse> getMyProfile(@AuthenticationPrincipal Jwt jwt) {
        String keycloakId = jwt.getSubject();
        String email = jwt.getClaimAsString("email");
        String name = jwt.getClaimAsString("preferred_username");

        User user = registerUserUseCase.registerOrGet(keycloakId, email, name);
        return ResponseEntity.ok(userMapper.toResponse(user));
    }

    @PutMapping("/me")
    @Operation(summary = "Update current user profile")
    public ResponseEntity<UserProfileResponse> updateMyProfile(
            @AuthenticationPrincipal Jwt jwt,
            @Valid @RequestBody UpdateProfileRequest request) {

        String keycloakId = jwt.getSubject();
        User updated = updateProfileUseCase.updateProfile(keycloakId, request);
        return ResponseEntity.ok(userMapper.toResponse(updated));
    }
}
