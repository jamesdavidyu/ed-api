package com.schooltecher.api.service;

import com.schooltecher.api.dto.LessonDTO;
import com.schooltecher.api.model.Lessons;
import com.schooltecher.api.model.Users;
import com.schooltecher.api.repository.LessonRepository;
import com.schooltecher.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LessonRepository lessonRepository;

    public LessonDTO create(Lessons lesson) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            Users techer = userRepository.findByUsername(((UserDetails) authentication.getPrincipal()).getUsername());
            lesson.setTecherId(techer);
            lessonRepository.save(lesson);
            LessonDTO lessonResponse = new LessonDTO(lesson.getId(), lesson.getLesson(), lesson.getCreatedAt(), techer.getId());
            return lessonResponse;
        } else {
            return null;
        }
    }

    public List<Lessons> get() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            Users techer = userRepository.findByUsername(((UserDetails) authentication.getPrincipal()).getUsername());
            List<Lessons> lessons = lessonRepository.findByTecherId(techer);
//            LessonDTO lessonResponse = new <List>LessonDTO(lessons.getId(), lessons.getLesson(), lessons.getCreatedAt(), techer.getId());
            return lessons;
        } else {
            return null;
        }
    }
}
