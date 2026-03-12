package com.linguarise.user.infrastructure.entity;

import com.linguarise.shared.domain.CEFRLevel;
import com.linguarise.shared.domain.ExamType;
import com.linguarise.user.domain.model.User.LearningGoal;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class UserJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "keycloak_id", nullable = false, unique = true)
    private String keycloakId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "cefr_level")
    @Enumerated(EnumType.STRING)
    private CEFRLevel cefrLevel;

    @Column(name = "learning_goal")
    @Enumerated(EnumType.STRING)
    private LearningGoal learningGoal;

    @Column(name = "target_exam")
    @Enumerated(EnumType.STRING)
    private ExamType targetExam;

    @Column(name = "yokdil_domain")
    private String yokdilDomain;

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
