package com.linguarise.assessment.application.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.Map;

public record SubmitPlacementTestRequest(
        @NotEmpty(message = "answers boş olamaz")
        Map<String, String> answers
) {}