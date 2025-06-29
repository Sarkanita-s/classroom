package com.edutech.grades.service;

import com.edutech.common.dto.QuizDTO;
import com.edutech.grades.client.CourseClient;
import com.edutech.grades.entity.Quiz;
import com.edutech.grades.mapper.QuizMapper;
import com.edutech.grades.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.edutech.common.exception.ExceptionUtils.orThrow;
import static com.edutech.common.exception.ExceptionUtils.orThrowFeign;

@Service
@RequiredArgsConstructor
public class QuizService {
    private QuizRepository quizRepo;
    private QuizMapper quizMapper;
    private CourseClient courseClient;

    public List<QuizDTO> findAll() {
        return quizRepo.findAll().stream().map(quizMapper::toDTO).toList();
    }

    public QuizDTO findById(Integer id) {
        return quizMapper.toDTO(orThrow(quizRepo.findById(id), "Quiz"));
    }

    public QuizDTO create(QuizDTO dto) {
        // Validar que el curso exista (comunicación con ms-courses)
        orThrowFeign(dto.getCourseId(), courseClient::findById, "Curso");
        
        return saveDTO(dto, null);
    }

    public QuizDTO update(Integer id, QuizDTO dto) {
        orThrow(quizRepo.findById(id), "Quiz");
        return saveDTO(dto, id);
    }

    public void delete(Integer id) {
        quizRepo.delete(orThrow(quizRepo.findById(id), "Quiz"));
    }

    private QuizDTO saveDTO(QuizDTO dto, Integer id) {
        Quiz entity = quizMapper.toEntity(dto);
        if (id != null) entity.setId(id);
        return quizMapper.toDTO(quizRepo.save(entity));
    }
}