package com.schooltecher.api.controller;

import com.schooltecher.api.dto.QuestionDTO;
import com.schooltecher.api.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/auth/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/{lessonId}")
    public QuestionDTO create(@RequestBody QuestionDTO request, @PathVariable UUID lessonId) {
        return questionService.create(lessonId, request.getQuestion());
    }

    @GetMapping("/{lessonId}")
    public List<QuestionDTO> get(@PathVariable UUID lessonId) {
        return questionService.get(lessonId);
    }
}
