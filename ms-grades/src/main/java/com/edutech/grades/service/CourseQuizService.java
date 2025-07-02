package com.edutech.grades.service;

import com.edutech.common.dto.CourseQuizDTO;
import com.edutech.grades.client.CourseClient;
import com.edutech.grades.entity.CourseQuiz;
import com.edutech.grades.mapper.CourseQuizMapper;
import com.edutech.grades.repository.CourseQuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.edutech.common.exception.ExceptionUtils.orThrow;
import static com.edutech.common.exception.ExceptionUtils.orThrowFeign;

@Service
@RequiredArgsConstructor
public class CourseQuizService {

    private final CourseQuizRepository quizRepo;
    private final CourseQuizMapper quizMapper;
    private final CourseClient courseClient;

    public List<CourseQuizDTO> findAll() {
        return quizRepo.findAll().stream().map(quizMapper::toDTO).toList();
    }

    public CourseQuizDTO findById(Integer id) {
        return quizMapper.toDTO(orThrow(quizRepo.findById(id), "Quiz del curso"));
    }

    public CourseQuizDTO create(CourseQuizDTO dto) {
        orThrowFeign(dto.getCourseId(), courseClient::findById, "Curso");
        
        CourseQuiz entity = quizMapper.toEntity(dto);
        return quizMapper.toDTO(quizRepo.save(entity));
    }

    public CourseQuizDTO update(Integer id, CourseQuizDTO dto) {
        orThrow(quizRepo.findById(id), "Quiz del curso");
        return saveDTO(dto, id);
    }

    public void delete(Integer id) {
        quizRepo.delete(orThrow(quizRepo.findById(id), "Quiz del curso"));
    }

    private CourseQuizDTO saveDTO(CourseQuizDTO dto, Integer id) {
        CourseQuiz entity = quizMapper.toEntity(dto);
        if (id != null) entity.setId(id);
        return quizMapper.toDTO(quizRepo.save(entity));
    }
}