package com.linguarise.user.application.dto;

import com.linguarise.shared.domain.CEFRLevel;
import com.linguarise.shared.domain.ExamType;
import com.linguarise.user.domain.model.User.LearningGoal;
import java.time.LocalDateTime;

public record UserProfileResponse(
        Long id,
        String email,
        String displayName,
        CEFRLevel cefrLevel,
        LearningGoal learningGoal,
        ExamType targetExam,
        String yokdilDomain,
        LocalDateTime createdAt
) {}
