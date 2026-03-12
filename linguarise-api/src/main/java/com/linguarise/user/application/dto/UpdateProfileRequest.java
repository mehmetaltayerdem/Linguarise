package com.linguarise.user.application.dto;

import com.linguarise.shared.domain.ExamType;
import com.linguarise.user.domain.model.User.LearningGoal;
import jakarta.validation.constraints.Size;

public record UpdateProfileRequest(
        @Size(min = 2, max = 100, message = "Display name must be 2-100 characters")
        String displayName,
        LearningGoal learningGoal,
        ExamType targetExam,
        String yokdilDomain
) {}
