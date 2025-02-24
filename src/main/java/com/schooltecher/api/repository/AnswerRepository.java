package com.schooltecher.api.repository;

import com.schooltecher.api.model.Answers;
import com.schooltecher.api.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AnswerRepository extends JpaRepository<Answers, UUID> {
    List<Answers> findByQuestionId(Questions questionId);
}
