package com.schooltecher.api.repository;

import com.schooltecher.api.model.Lessons;
import com.schooltecher.api.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface QuestionRepository extends JpaRepository<Questions, UUID> {
    List<Questions> findByLessonId(Lessons lessonId);
}
