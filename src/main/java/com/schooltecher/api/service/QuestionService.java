package com.schooltecher.api.service;

import com.schooltecher.api.dto.QuestionDTO;
import com.schooltecher.api.model.Lessons;
import com.schooltecher.api.model.Questions;
import com.schooltecher.api.repository.LessonRepository;
import com.schooltecher.api.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private LessonRepository lessonRepository;

    public QuestionDTO create(UUID uuidLessonId, String question) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            Lessons lessonId = lessonRepository.findById(uuidLessonId)
                    .orElseThrow(() -> new RuntimeException("Lesson not found"));
            Questions questions = new Questions();
            questions.setLessonId(lessonId);
            questions.setQuestion(question);
            questionRepository.save(questions);
            QuestionDTO questionResponse = new QuestionDTO(questions.getId(), question, questions.getCreatedAt(), uuidLessonId);
            return questionResponse;
        } else {
            return null;
        }
    }

    public List<QuestionDTO> get(UUID uuidLessonId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof  UserDetails) {
            Lessons lessonId = lessonRepository.findById(uuidLessonId)
                    .orElseThrow(() -> new RuntimeException("Lesson not found"));
            List<Questions> questions = questionRepository.findByLessonId(lessonId);
            return questions.stream()
                    .map(question -> new QuestionDTO(question.getId(), question.getQuestion(), question.getCreatedAt(), lessonId.getId()))
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }
}
