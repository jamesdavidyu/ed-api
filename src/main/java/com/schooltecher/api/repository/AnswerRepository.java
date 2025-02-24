package com.schooltecher.api.repository;

import com.schooltecher.api.model.Answers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnswerRepository extends JpaRepository<Answers, UUID> {
}
