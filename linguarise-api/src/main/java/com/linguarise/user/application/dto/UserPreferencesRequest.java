package com.linguarise.user.application.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record UserPreferencesRequest(
        @NotNull
        @Min(value = 1, message = "dailyWordGoal en az 1 olmalı")
        @Max(value = 100, message = "dailyWordGoal en fazla 100 olabilir")
        Integer dailyWordGoal,

        @NotNull
        @Min(value = 1, message = "dailyReadingGoal en az 1 olmalı")
        @Max(value = 20, message = "dailyReadingGoal en fazla 20 olabilir")
        Integer dailyReadingGoal,

        @NotNull
        @Min(value = 1, message = "dailyQuizGoal en az 1 olmalı")
        @Max(value = 20, message = "dailyQuizGoal en fazla 20 olabilir")
        Integer dailyQuizGoal,

        @NotNull
        @Min(value = 1, message = "dailyReviewGoal en az 1 olmalı")
        @Max(value = 200, message = "dailyReviewGoal en fazla 200 olabilir")
        Integer dailyReviewGoal,

        @Size(max = 10, message = "En fazla 10 ilgi alanı seçilebilir")
        List<String> interests,

        @NotNull
        Boolean notificationEnabled
) {}