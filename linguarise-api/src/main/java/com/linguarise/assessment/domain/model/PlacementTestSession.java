package com.linguarise.assessment.domain.model;

import java.time.LocalDateTime;

public record PlacementTestSession(
        String testId,
        Long userId,
        LocalDateTime startedAt
) {}