package com.schooltecher.api.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="Answers")
public class Answers {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(nullable = false)
    private String answer;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Questions questionId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Users studentId;

    public Answers() {}

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

    public Questions getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Questions questionId) {
        this.questionId = questionId;
    }

    public Users getStudentId() {
        return studentId;
    }

    public void setStudentId(Users studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Answers{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", questionId='" + questionId + '\'' +
                ", studentId='" + studentId + '\'' +
                '}';
    }
}
