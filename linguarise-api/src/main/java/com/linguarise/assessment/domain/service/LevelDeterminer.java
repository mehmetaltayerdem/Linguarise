package com.linguarise.assessment.domain.service;

import com.linguarise.shared.domain.CEFRLevel;
import org.springframework.stereotype.Component;

@Component
public class LevelDeterminer {

    public CEFRLevel determine(int score, int totalQuestions) {
        if (totalQuestions <= 0) {
            return CEFRLevel.A1;
        }

        double percentage = (score * 100.0) / totalQuestions;

        if (percentage < 20) return CEFRLevel.A1;
        if (percentage < 40) return CEFRLevel.A2;
        if (percentage < 60) return CEFRLevel.B1;
        if (percentage < 75) return CEFRLevel.B2;
        if (percentage < 90) return CEFRLevel.C1;
        return CEFRLevel.C2;
    }
}