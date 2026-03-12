package com.linguarise.assessment.domain.model;

import com.linguarise.shared.domain.QuestionType;

import java.util.List;

public class PlacementQuestion {

    private String id;
    private QuestionType questionType;
    private String category;
    private String question;
    private List<String> options;
    private String correctAnswer;
    private String explanation;
    private Integer orderNo;

    public PlacementQuestion() {
    }

    public PlacementQuestion(
            String id,
            QuestionType questionType,
            String category,
            String question,
            List<String> options,
            String correctAnswer,
            String explanation,
            Integer orderNo
    ) {
        this.id = id;
        this.questionType = questionType;
        this.category = category;
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.explanation = explanation;
        this.orderNo = orderNo;
    }

    public String getId() { return id; }
    public QuestionType getQuestionType() { return questionType; }
    public String getCategory() { return category; }
    public String getQuestion() { return question; }
    public List<String> getOptions() { return options; }
    public String getCorrectAnswer() { return correctAnswer; }
    public String getExplanation() { return explanation; }
    public Integer getOrderNo() { return orderNo; }

    public void setId(String id) { this.id = id; }
    public void setQuestionType(QuestionType questionType) { this.questionType = questionType; }
    public void setCategory(String category) { this.category = category; }
    public void setQuestion(String question) { this.question = question; }
    public void setOptions(List<String> options) { this.options = options; }
    public void setCorrectAnswer(String correctAnswer) { this.correctAnswer = correctAnswer; }
    public void setExplanation(String explanation) { this.explanation = explanation; }
    public void setOrderNo(Integer orderNo) { this.orderNo = orderNo; }
}