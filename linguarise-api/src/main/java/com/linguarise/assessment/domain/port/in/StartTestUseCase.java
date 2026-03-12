package com.linguarise.assessment.domain.port.in;

import com.linguarise.assessment.application.dto.StartPlacementTestResponse;

public interface StartTestUseCase {
    StartPlacementTestResponse start(String keycloakId);
}