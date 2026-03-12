package com.linguarise.assessment.domain.port.in;

import com.linguarise.assessment.application.dto.SubmitPlacementTestRequest;
import com.linguarise.assessment.application.dto.SubmitPlacementTestResponse;

public interface SubmitTestUseCase {
    SubmitPlacementTestResponse submit(String keycloakId, String testId, SubmitPlacementTestRequest request);
}