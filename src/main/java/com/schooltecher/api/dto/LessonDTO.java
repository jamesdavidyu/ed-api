package com.schooltecher.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.schooltecher.api.model.Lessons;

import java.time.LocalDateTime;
import java.util.UUID;

public class LessonDTO {
    private UUID id;
    private String lesson;
    private LocalDateTime createdAt;
    private UUID techerId;

    @JsonCreator
    public LessonDTO(@JsonProperty("id") UUID id,
                     @JsonProperty("lesson") String lesson,
                     @JsonProperty("createdAt") LocalDateTime createdAt,
                     @JsonProperty("techerId") UUID techerId) {
        this.id = id;
        this.lesson = lesson;
        this.createdAt = createdAt;
        this.techerId = techerId;
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
