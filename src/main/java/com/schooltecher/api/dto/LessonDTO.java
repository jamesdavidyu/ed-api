package com.schooltecher.api.dto;

import com.schooltecher.api.model.Lessons;

import java.time.LocalDateTime;
import java.util.UUID;

public class LessonDTO {
    private UUID id;
    private String lesson;
    private LocalDateTime createdAt;
    private UUID techerId;

    public LessonDTO(Lessons lesson) {
        this.id = lesson.getId();
        this.lesson = lesson.getLesson();
        this.createdAt = lesson.getCreatedAt();
        this.techerId = lesson.getTecherId() != null ? lesson.getTecherId().getId() : null;
    }

    public UUID getId() {
        return id;
    }

    public String getLesson() {
        return lesson;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public UUID getTecherId() {
        return techerId;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setTecherId(UUID techerId) {
        this.techerId = techerId;
    }
}
