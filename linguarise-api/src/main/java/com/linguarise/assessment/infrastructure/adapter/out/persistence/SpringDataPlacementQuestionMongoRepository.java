package com.linguarise.assessment.infrastructure.adapter.out.persistence;

import com.linguarise.assessment.infrastructure.document.PlacementQuestionDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SpringDataPlacementQuestionMongoRepository
        extends MongoRepository<PlacementQuestionDocument, String> {

    List<PlacementQuestionDocument> findAllByOrderByOrderNoAsc();
}