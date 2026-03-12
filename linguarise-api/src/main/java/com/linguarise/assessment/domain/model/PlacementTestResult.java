package com.linguarise.assessment.domain.model;

import com.linguarise.shared.domain.CEFRLevel;

import java.time.LocalDateTime;
import java.util.Map;

public class PlacementTestResult {

    private Long id;
    private Long userId;
    private Integer score;
    private Integer totalQuestions;
    private CEFRLevel cefrLevel;
    private LocalDateTime startedAt;
    private LocalDateTime completedAt;
    private Map<String, String> answers;

    public PlacementTestResult() {
    }

    public PlacementTestResult(
            Long id,
            Long userId,
            Integer score,
            Integer totalQuestions,
            CEFRLevel cefrLevel,
            LocalDateTime startedAt,
            LocalDateTime completedAt,
            Map<String, String> answers
    ) {
        this.id = id;
        this.userId = userId;
        this.score = score;
        this.totalQuestions = totalQuestions;
        this.cefrLevel = cefrLevel;
        this.startedAt = startedAt;
        this.completedAt = completedAt;
        this.answers = answers;
    }

    public static PlacementTestResult create(
            Long userId,
            Integer score,
            Integer totalQuestions,
            CEFRLevel cefrLevel,
            LocalDateTime startedAt,
            LocalDateTime completedAt,
            Map<String, String> answers
    ) {
        return new PlacementTestResult(
                null,
                userId,
                score,
                totalQuestions,
                cefrLevel,
                startedAt,
                completedAt,
                answers
        );
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public Integer getScore() { return score; }
    public Integer getTotalQuestions() { return totalQuestions; }
    public CEFRLevel getCefrLevel() { return cefrLevel; }
    public LocalDateTime getStartedAt() { return startedAt; }
    public LocalDateTime getCompletedAt() { return completedAt; }
    public Map<String, String> getAnswers() { return answers; }

    public void setId(Long id) { this.id = id; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setScore(Integer score) { this.score = score; }
    public void setTotalQuestions(Integer totalQuestions) { this.totalQuestions = totalQuestions; }
    public void setCefrLevel(CEFRLevel cefrLevel) { this.cefrLevel = cefrLevel; }
    public void setStartedAt(LocalDateTime startedAt) { this.startedAt = startedAt; }
    public void setCompletedAt(LocalDateTime completedAt) { this.completedAt = completedAt; }
    public void setAnswers(Map<String, String> answers) { this.answers = answers; }
}