package com.schooltecher.api.controller;

import com.schooltecher.api.dto.LessonDTO;
import com.schooltecher.api.model.Lessons;
import com.schooltecher.api.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @PostMapping("/lessons")
    public LessonDTO create(@RequestBody Lessons lesson) {
        return lessonService.create(lesson);
    }

    @GetMapping("/lessons")
    public List<LessonDTO> get() {
        return lessonService.get();
    }
}
