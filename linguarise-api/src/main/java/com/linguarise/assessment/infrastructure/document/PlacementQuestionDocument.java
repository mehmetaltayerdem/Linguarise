package com.linguarise.assessment.infrastructure.document;

import com.linguarise.shared.domain.QuestionType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "placement_questions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlacementQuestionDocument {

    @Id
    private String id;

    private QuestionType questionType;
    private String category;
    private String question;
    private List<String> options;
    private String correctAnswer;
    private String explanation;
    private Integer orderNo;
}