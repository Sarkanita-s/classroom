package com.edutech.grades.service;

import com.edutech.common.dto.CourseQuizQuestionDTO;
import com.edutech.grades.entity.CourseQuizQuestion;
import com.edutech.grades.mapper.CourseQuizQuestionMapper;
import com.edutech.grades.repository.CourseQuizQuestionRepository;
import com.edutech.grades.repository.CourseQuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.edutech.common.exception.ExceptionUtils.orThrow;

@Service
@RequiredArgsConstructor
public class CourseQuizQuestionService {

    private final CourseQuizQuestionRepository questionRepo;
    private final CourseQuizRepository quizRepo;
    private final CourseQuizQuestionMapper questionMapper;

    public List<CourseQuizQuestionDTO> findAll() {
        return questionRepo.findAll().stream().map(questionMapper::toDTO).toList();
    }

    public CourseQuizQuestionDTO findById(Integer id) {
        return questionMapper.toDTO(orThrow(questionRepo.findById(id), "Pregunta"));
    }

    public CourseQuizQuestionDTO create(CourseQuizQuestionDTO dto) {
        orThrow(quizRepo.findById(dto.getCourseQuizId()), "Quiz del curso");
        
        CourseQuizQuestion entity = questionMapper.toEntity(dto);
        return questionMapper.toDTO(questionRepo.save(entity));
    }

    public CourseQuizQuestionDTO update(Integer id, CourseQuizQuestionDTO dto) {
        orThrow(questionRepo.findById(id), "Pregunta");
        return saveDTO(dto, id);
    }

    public void delete(Integer id) {
        questionRepo.delete(orThrow(questionRepo.findById(id), "Pregunta"));
    }

    private CourseQuizQuestionDTO saveDTO(CourseQuizQuestionDTO dto, Integer id) {
        CourseQuizQuestion entity = questionMapper.toEntity(dto);
        if (id != null) entity.setId(id);
        return questionMapper.toDTO(questionRepo.save(entity));
    }
}