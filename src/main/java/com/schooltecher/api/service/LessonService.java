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
            LessonDTO lessonResponse = new LessonDTO(lesson);
            return lessonResponse;
        } else {
            return null;
        }
    }
}
