package com.linguarise.user.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserPreferences {

    private Long id;
    private Long userId;
    private Integer dailyWordGoal;
    private Integer dailyReadingGoal;
    private Integer dailyQuizGoal;
    private Integer dailyReviewGoal;
    private List<String> interests;
    private Boolean notificationEnabled;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static UserPreferences createDefault(Long userId) {
        UserPreferences preferences = new UserPreferences();
        preferences.userId = userId;
        preferences.dailyWordGoal = 5;
        preferences.dailyReadingGoal = 1;
        preferences.dailyQuizGoal = 1;
        preferences.dailyReviewGoal = 10;
        preferences.interests = new ArrayList<>();
        preferences.notificationEnabled = true;
        preferences.createdAt = LocalDateTime.now();
        preferences.updatedAt = LocalDateTime.now();
        return preferences;
    }

    public void update(
            Integer dailyWordGoal,
            Integer dailyReadingGoal,
            Integer dailyQuizGoal,
            Integer dailyReviewGoal,
            List<String> interests,
            Boolean notificationEnabled
    ) {
        this.dailyWordGoal = dailyWordGoal;
        this.dailyReadingGoal = dailyReadingGoal;
        this.dailyQuizGoal = dailyQuizGoal;
        this.dailyReviewGoal = dailyReviewGoal;
        this.interests = interests != null ? interests : new ArrayList<>();
        this.notificationEnabled = notificationEnabled;
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public Integer getDailyWordGoal() { return dailyWordGoal; }
    public Integer getDailyReadingGoal() { return dailyReadingGoal; }
    public Integer getDailyQuizGoal() { return dailyQuizGoal; }
    public Integer getDailyReviewGoal() { return dailyReviewGoal; }
    public List<String> getInterests() { return interests; }
    public Boolean getNotificationEnabled() { return notificationEnabled; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setId(Long id) { this.id = id; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setDailyWordGoal(Integer dailyWordGoal) { this.dailyWordGoal = dailyWordGoal; }
    public void setDailyReadingGoal(Integer dailyReadingGoal) { this.dailyReadingGoal = dailyReadingGoal; }
    public void setDailyQuizGoal(Integer dailyQuizGoal) { this.dailyQuizGoal = dailyQuizGoal; }
    public void setDailyReviewGoal(Integer dailyReviewGoal) { this.dailyReviewGoal = dailyReviewGoal; }
    public void setInterests(List<String> interests) { this.interests = interests; }
    public void setNotificationEnabled(Boolean notificationEnabled) { this.notificationEnabled = notificationEnabled; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}