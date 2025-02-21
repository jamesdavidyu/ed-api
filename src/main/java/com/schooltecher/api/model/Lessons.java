package com.schooltecher.api.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="lessons")
public class Lessons {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(nullable = false)
    private String lesson;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "techer_id", nullable = false)
    private Users techerId;

    @OneToMany(mappedBy = "lessonId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Questions> questions;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Users getTecherId() {
        return techerId;
    }

    public void setTecherId(Users techerId) {
        this.techerId = techerId;
    }

    @Override
    public String toString() {
        return "Lessons{" +
                "id=" + id +
                ", lesson='" + lesson + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", techerId='" + techerId + '\'' +
                '}';
    }
}
