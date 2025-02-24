package com.schooltecher.api.controller;

import com.schooltecher.api.dto.AnswerDTO;
import com.schooltecher.api.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/auth/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping("/create/{questionId}")
    public AnswerDTO create(@RequestBody AnswerDTO request, @PathVariable UUID questionId) {
        return answerService.create(questionId, request.getAnswer());
    }
}
