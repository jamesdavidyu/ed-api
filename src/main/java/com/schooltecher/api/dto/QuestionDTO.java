package com.schooltecher.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.UUID;

public class QuestionDTO {
    private UUID id;
    private String question;
    private LocalDateTime createdAt;
    private UUID lessonId;

    @JsonCreator
    public QuestionDTO(@JsonProperty("id") UUID id,
                       @JsonProperty("question") String question,
                       @JsonProperty("createdAt") LocalDateTime createdAt,
                       @JsonProperty("lessonId") UUID lessonId) {
        this.id = id;
        this.question = question;
        this.createdAt = createdAt;
        this.lessonId = lessonId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UUID getLessonId() {
        return lessonId;
    }

    public void setLessonId(UUID lessonId) {
        this.lessonId = lessonId;
    }
}
