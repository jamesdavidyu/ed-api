package com.schooltecher.api.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="schooltechers")
public class Users {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "techerId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lessons> lessons;

//    @OneToMany(mappedBy = "studentId", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Answers> answers;
//
//    @OneToMany(mappedBy = "studentId", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Grades> grades;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Lessons> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lessons> lessons) {
        this.lessons = lessons;
    }

//    public List<Answers> getAnswers() {
//        return answers;
//    }
//
//    public void setAnswers(List<Answers> answers) {
//        this.answers = answers;
//    }
//
//    public List<Grades> getGrades() {
//        return grades;
//    }
//
//    public void setGrades(List<Grades> grades) {
//        this.grades = grades;
//    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", lessons='" + lessons + '\'' +
//                ", answers='" + answers + '\'' +
//                ", grades='" + grades + '\'' +
                '}';
    }
}
