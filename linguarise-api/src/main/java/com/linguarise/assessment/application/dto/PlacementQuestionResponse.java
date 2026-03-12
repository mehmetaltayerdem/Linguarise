package com.linguarise.assessment.application.dto;

import com.linguarise.shared.domain.QuestionType;

import java.util.List;

public record PlacementQuestionResponse(
        String id,
        QuestionType questionType,
        String category,
        String question,
        List<String> options,
        Integer orderNo
) {}