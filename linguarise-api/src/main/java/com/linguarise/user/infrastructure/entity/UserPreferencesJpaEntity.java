package com.linguarise.user.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_preferences")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPreferencesJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false, unique = true)
    private Long userId;

    @Column(name = "daily_word_goal", nullable = false)
    private Integer dailyWordGoal;

    @Column(name = "daily_reading_goal", nullable = false)
    private Integer dailyReadingGoal;

    @Column(name = "daily_quiz_goal", nullable = false)
    private Integer dailyQuizGoal;

    @Column(name = "daily_review_goal", nullable = false)
    private Integer dailyReviewGoal;

    @Column(name = "interests", columnDefinition = "text[]")
    private String[] interests;

    @Column(name = "notification_enabled", nullable = false)
    private Boolean notificationEnabled;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}