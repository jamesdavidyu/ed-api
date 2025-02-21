package com.schooltecher.api.repository;

import com.schooltecher.api.model.Lessons;
import com.schooltecher.api.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LessonRepository extends JpaRepository<Lessons, UUID> {
    List<Lessons> findByTecherId(Users techerId);
}
