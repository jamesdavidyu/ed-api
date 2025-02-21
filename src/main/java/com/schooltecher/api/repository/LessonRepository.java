package com.schooltecher.api.repository;

import com.schooltecher.api.dto.LessonDTO;
import com.schooltecher.api.model.Lessons;
import com.schooltecher.api.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface LessonRepository extends JpaRepository<Lessons, UUID> {
    List<LessonDTO> findByTecherId(@Param("techerId") UUID techerId);
}
