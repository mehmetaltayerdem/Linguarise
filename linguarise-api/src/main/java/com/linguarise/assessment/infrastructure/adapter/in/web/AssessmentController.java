package com.linguarise.assessment.infrastructure.adapter.in.web;

import com.linguarise.assessment.application.dto.StartPlacementTestResponse;
import com.linguarise.assessment.application.dto.SubmitPlacementTestRequest;
import com.linguarise.assessment.application.dto.SubmitPlacementTestResponse;
import com.linguarise.assessment.domain.port.in.StartTestUseCase;
import com.linguarise.assessment.domain.port.in.SubmitTestUseCase;
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
@RequestMapping("/api/v1/assessment")
@RequiredArgsConstructor
@Tag(name = "Assessment", description = "Placement test endpoints")
@SecurityRequirement(name = "Bearer Authentication")
public class AssessmentController {

    private final StartTestUseCase startTestUseCase;
    private final SubmitTestUseCase submitTestUseCase;

    @PostMapping("/start")
    @Operation(summary = "Start placement test")
    public ResponseEntity<StartPlacementTestResponse> start(@AuthenticationPrincipal Jwt jwt) {
        String keycloakId = jwt.getSubject();
        return ResponseEntity.ok(startTestUseCase.start(keycloakId));
    }

    @PostMapping("/{testId}/submit")
    @Operation(summary = "Submit placement test")
    public ResponseEntity<SubmitPlacementTestResponse> submit(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable String testId,
            @Valid @RequestBody SubmitPlacementTestRequest request) {

        String keycloakId = jwt.getSubject();
        return ResponseEntity.ok(submitTestUseCase.submit(keycloakId, testId, request));
    }
}