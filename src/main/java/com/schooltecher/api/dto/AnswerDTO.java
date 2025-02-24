package com.schooltecher.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.UUID;

public class AnswerDTO {
    private UUID id;
    private String answer;
    private LocalDateTime createdAt;
    private UUID questionId;
    private UUID studentId;

    @JsonCreator
    public AnswerDTO(@JsonProperty("id") UUID id,
                     @JsonProperty("answer") String answer,
                     @JsonProperty("createdAt") LocalDateTime createdAt,
                     @JsonProperty("questionId") UUID questionId,
                     @JsonProperty("studentId") UUID studentId) {
        this.id = id;
        this.answer = answer;
        this.createdAt = createdAt;
        this.questionId = questionId;
        this.studentId = studentId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UUID getQuestionId() {
        return questionId;
    }

    public void setQuestionId(UUID questionId) {
        this.questionId = questionId;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public void setStudentId(UUID studentId) {
        this.studentId = studentId;
    }
}
