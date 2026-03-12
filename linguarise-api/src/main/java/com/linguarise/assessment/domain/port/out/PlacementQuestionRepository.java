package com.linguarise.assessment.domain.port.out;

import com.linguarise.assessment.domain.model.PlacementQuestion;

import java.util.List;

public interface PlacementQuestionRepository {
    List<PlacementQuestion> findAllPlacementQuestions();
}