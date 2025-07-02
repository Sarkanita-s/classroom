package com.edutech.grades.service;

import com.edutech.common.dto.QuizResponseDTO;
import com.edutech.grades.client.UserClient;
import com.edutech.grades.entity.QuizResponse;
import com.edutech.grades.mapper.QuizResponseMapper;
import com.edutech.grades.repository.QuizResponseRepository;
import com.edutech.grades.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

import static com.edutech.common.exception.ExceptionUtils.orThrow;
import static com.edutech.common.exception.ExceptionUtils.orThrowFeign;

@Service
@RequiredArgsConstructor
public class QuizResponseService {

    private final QuizResponseRepository responseRepo;
    private final QuizRepository quizRepo;
    private final QuizResponseMapper responseMapper;
    private final UserClient userClient;

    public QuizResponseDTO create(QuizResponseDTO dto) {
        orThrow(quizRepo.findById(dto.getQuizId()), "Quiz");
        orThrowFeign(dto.getStudentId(), userClient::findById, "Estudiante");
        
        QuizResponse entity = responseMapper.toEntity(dto);
        return responseMapper.toDTO(responseRepo.save(entity));
    }

    public void delete(Integer id) {
        responseRepo.delete(orThrow(responseRepo.findById(id), "Respuesta de quiz"));
    }
}