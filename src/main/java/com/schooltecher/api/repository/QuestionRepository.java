package com.schooltecher.api.repository;

import com.schooltecher.api.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuestionRepository extends JpaRepository<Questions, UUID> {
}
