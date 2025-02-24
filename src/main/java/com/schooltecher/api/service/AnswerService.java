package com.schooltecher.api.service;

import com.schooltecher.api.dto.AnswerDTO;
import com.schooltecher.api.model.Answers;
import com.schooltecher.api.model.Questions;
import com.schooltecher.api.model.Users;
import com.schooltecher.api.repository.AnswerRepository;
import com.schooltecher.api.repository.QuestionRepository;
import com.schooltecher.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AnswerService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AnswerRepository answerRepository;

    public AnswerDTO create(UUID uuidQuestionId, String answer) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            Users studentId = userRepository.findByUsername(((UserDetails) authentication.getPrincipal()).getUsername());
            Questions questionId = questionRepository.findById(uuidQuestionId)
                    .orElseThrow(() -> new RuntimeException("Question not found"));
            Answers answers = new Answers();
            answers.setQuestionId(questionId);
            answers.setStudentId(studentId);
            answers.setAnswer(answer);
            answerRepository.save(answers);
            AnswerDTO answerResponse = new AnswerDTO(answers.getId(), answer, answers.getCreatedAt(), uuidQuestionId, studentId.getId());
            return answerResponse;
//            TODO: need to add logic such that studentId doesn't equal techerId of who is asking question?
        } else {
            return null;
        }
    }

    public List<AnswerDTO> get(UUID uuidQuestionId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            Questions questionId = questionRepository.findById(uuidQuestionId)
                    .orElseThrow(() -> new RuntimeException("Question not found"));
            List<Answers> answers = answerRepository.findByQuestionId(questionId);
            return answers.stream()
                    .map(answer -> new AnswerDTO(answer.getId(), answer.getAnswer(), answer.getCreatedAt(), uuidQuestionId, answer.getStudentId().getId()))
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }
}
