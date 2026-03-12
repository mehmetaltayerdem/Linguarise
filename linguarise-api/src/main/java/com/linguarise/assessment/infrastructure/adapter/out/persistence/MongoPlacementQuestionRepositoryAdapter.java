package com.linguarise.assessment.infrastructure.adapter.out.persistence;

import com.linguarise.assessment.domain.model.PlacementQuestion;
import com.linguarise.assessment.domain.port.out.PlacementQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MongoPlacementQuestionRepositoryAdapter implements PlacementQuestionRepository {

    private final SpringDataPlacementQuestionMongoRepository mongoRepository;

    @Override
    public List<PlacementQuestion> findAllPlacementQuestions() {
        return mongoRepository.findAllByOrderByOrderNoAsc()
                .stream()
                .map(doc -> new PlacementQuestion(
                        doc.getId(),
                        doc.getQuestionType(),
                        doc.getCategory(),
                        doc.getQuestion(),
                        doc.getOptions(),
                        doc.getCorrectAnswer(),
                        doc.getExplanation(),
                        doc.getOrderNo()
                ))
                .toList();
    }
}