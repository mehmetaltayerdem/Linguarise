package com.linguarise.assessment.application.dto;

import com.linguarise.shared.domain.CEFRLevel;

public record SubmitPlacementTestResponse(
        Long resultId,
        Integer score,
        Integer totalQuestions,
        CEFRLevel cefrLevel
) {}