package com.edutech.grades.service;

import com.edutech.common.dto.StudentMarkDTO;
import com.edutech.grades.client.UserClient;
import com.edutech.grades.entity.StudentMark;
import com.edutech.grades.mapper.StudentMarkMapper;
import com.edutech.grades.repository.StudentMarkRepository;
import com.edutech.grades.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.edutech.common.exception.ExceptionUtils.orThrow;
import static com.edutech.common.exception.ExceptionUtils.orThrowFeign;

@Service
public class StudentMarkService {

    @Autowired
    private StudentMarkRepository markRepo;
    
    @Autowired
    private QuizRepository quizRepo;
    
    @Autowired
    private StudentMarkMapper markMapper;
    
    @Autowired
    private UserClient userClient;

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