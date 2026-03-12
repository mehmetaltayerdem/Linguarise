package com.linguarise.assessment.domain.service;

import com.linguarise.assessment.domain.model.PlacementQuestion;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class ScoreCalculator {

    public int calculateScore(List<PlacementQuestion> questions, Map<String, String> answers) {
        if (questions == null || questions.isEmpty()) {
            return 0;
        }

        int score = 0;

        for (PlacementQuestion question : questions) {
            String userAnswer = answers.get(question.getId());
            if (userAnswer != null && Objects.equals(
                    normalize(userAnswer),
                    normalize(question.getCorrectAnswer())
            )) {
                score++;
            }
        }

        return score;
    }

    public int totalQuestions(List<PlacementQuestion> questions) {
        return questions == null ? 0 : questions.size();
    }

    private String normalize(String value) {
        return value == null ? "" : value.trim().toUpperCase();
    }
}