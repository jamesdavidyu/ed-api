package com.schooltecher.api.repository;

import com.schooltecher.api.model.Lessons;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LessonRepository extends JpaRepository<Lessons, UUID> {
}
