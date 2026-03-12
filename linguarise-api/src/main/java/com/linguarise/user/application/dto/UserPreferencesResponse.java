package com.linguarise.user.application.dto;

import java.time.LocalDateTime;
import java.util.List;

public record UserPreferencesResponse(
        Long id,
        Long userId,
        Integer dailyWordGoal,
        Integer dailyReadingGoal,
        Integer dailyQuizGoal,
        Integer dailyReviewGoal,
        List<String> interests,
        Boolean notificationEnabled,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}