package com.edutech.grades.service;

import com.edutech.common.dto.QuizResponseDTO;
import com.edutech.grades.client.UserClient;
import com.edutech.grades.mapper.QuizResponseMapper;
import com.edutech.grades.repository.QuizResponseRepository;
import com.edutech.grades.repository.CourseQuizQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

import static com.edutech.common.exception.ExceptionUtils.orThrow;
import static com.edutech.common.exception.ExceptionUtils.orThrowFeign;

@Service
public class QuizResponseService {

    @Autowired
    private QuizResponseRepository responseRepo;
    
    @Autowired
    private CourseQuizQuestionRepository questionRepo;
    
    @Autowired
    private QuizResponseMapper responseMapper;
    
    @Autowired
    private UserClient userClient;

    public QuizResponseDTO create(QuizResponseDTO dto) {
    orThrow(questionRepo.findById(dto.getId()), "Pregunta");
    orThrowFeign(dto.getStudentId(), userClient::findById, "Estudiante");
    dto.setSubmittedAt(Instant.now());
    return responseMapper.toDTO(responseRepo.save(responseMapper.toEntity(dto)));
}

    public void delete(Integer id) {
        responseRepo.delete(orThrow(responseRepo.findById(id), "Respuesta"));
    }
}