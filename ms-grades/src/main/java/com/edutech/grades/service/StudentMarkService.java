package com.edutech.grades.service;

import com.edutech.common.dto.StudentMarkDTO;
import com.edutech.grades.client.UserClient;
import com.edutech.grades.entity.StudentMark;
import com.edutech.grades.mapper.StudentMarkMapper;
import com.edutech.grades.repository.StudentMarkRepository;
import com.edutech.grades.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.edutech.common.exception.ExceptionUtils.orThrow;
import static com.edutech.common.exception.ExceptionUtils.orThrowFeign;

@Service
@RequiredArgsConstructor
public class StudentMarkService {

    private final StudentMarkRepository markRepo;
    private final QuizRepository quizRepo;
    private final StudentMarkMapper markMapper;
    private final UserClient userClient;

    public StudentMarkDTO create(StudentMarkDTO dto) {
        orThrow(quizRepo.findById(dto.getQuizId()), "Quiz");
        orThrowFeign(dto.getStudentId(), userClient::findById, "Estudiante");
        
        StudentMark entity = markMapper.toEntity(dto);
        return markMapper.toDTO(markRepo.save(entity));
    }

    public void delete(Integer id) {
        markRepo.delete(orThrow(markRepo.findById(id), "Calificación"));
    }
}