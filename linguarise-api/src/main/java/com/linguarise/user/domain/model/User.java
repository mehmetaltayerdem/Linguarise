package com.linguarise.user.domain.model;

import com.linguarise.shared.domain.CEFRLevel;
import com.linguarise.shared.domain.ExamType;

import java.time.LocalDateTime;

public class User {

    private Long id;
    private String keycloakId;
    private String email;
    private String displayName;
    private CEFRLevel cefrLevel;
    private LearningGoal learningGoal;
    private ExamType targetExam;
    private String yokdilDomain;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public enum LearningGoal {
        EXAM_PREP, CAREER, HOBBY, TRAVEL
    }

    // ═══ Factory method ═══
    public static User create(String keycloakId, String email, String displayName) {
        User user = new User();
        user.keycloakId = keycloakId;
        user.email = email;
        user.displayName = displayName;
        user.createdAt = LocalDateTime.now();
        user.updatedAt = LocalDateTime.now();
        return user;
    }

    // ═══ Domain behavior ═══
    public void updateLevel(CEFRLevel newLevel) {
        this.cefrLevel = newLevel;
        this.updatedAt = LocalDateTime.now();
    }

    public void updateProfile(String displayName, LearningGoal goal, ExamType exam, String yokdilDomain) {
        this.displayName = displayName;
        this.learningGoal = goal;
        this.targetExam = exam;
        this.yokdilDomain = yokdilDomain;
        this.updatedAt = LocalDateTime.now();
    }

    public boolean isPreparingForExam() {
        return this.learningGoal == LearningGoal.EXAM_PREP && this.targetExam != null;
    }

    // ═══ Getters ═══
    public Long getId() { return id; }
    public String getKeycloakId() { return keycloakId; }
    public String getEmail() { return email; }
    public String getDisplayName() { return displayName; }
    public CEFRLevel getCefrLevel() { return cefrLevel; }
    public LearningGoal getLearningGoal() { return learningGoal; }
    public ExamType getTargetExam() { return targetExam; }
    public String getYokdilDomain() { return yokdilDomain; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    // ═══ Setters (package-private for mapper) ═══
    public void setId(Long id) { this.id = id; }
    public void setKeycloakId(String keycloakId) { this.keycloakId = keycloakId; }
    public void setEmail(String email) { this.email = email; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }
    public void setCefrLevel(CEFRLevel cefrLevel) { this.cefrLevel = cefrLevel; }
    public void setLearningGoal(LearningGoal learningGoal) { this.learningGoal = learningGoal; }
    public void setTargetExam(ExamType targetExam) { this.targetExam = targetExam; }
    public void setYokdilDomain(String yokdilDomain) { this.yokdilDomain = yokdilDomain; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
