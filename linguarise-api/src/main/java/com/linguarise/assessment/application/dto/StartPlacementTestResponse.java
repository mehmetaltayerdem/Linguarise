package com.linguarise.assessment.application.dto;

import java.time.LocalDateTime;
import java.util.List;

public record StartPlacementTestResponse(
        String testId,
        LocalDateTime startedAt,
        Integer totalQuestions,
        List<PlacementQuestionResponse> questions
) {}