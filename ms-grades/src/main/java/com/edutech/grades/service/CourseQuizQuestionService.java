package com.edutech.grades.service;

import com.edutech.common.dto.CourseQuizQuestionDTO;
import com.edutech.grades.entity.CourseQuizQuestion;
import com.edutech.grades.mapper.CourseQuizQuestionMapper;
import com.edutech.grades.repository.CourseQuizQuestionRepository;
import com.edutech.grades.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.edutech.common.exception.ExceptionUtils.orThrow;

@Service
public class CourseQuizQuestionService {

    @Autowired
    private CourseQuizQuestionRepository questionRepo;
    
    @Autowired
    private QuizRepository quizRepo;
    
    @Autowired
    private CourseQuizQuestionMapper questionMapper;

    public CourseQuizQuestionDTO create(CourseQuizQuestionDTO dto) {
        orThrow(quizRepo.findById(dto.getQuizId()), "Quiz");
        
        CourseQuizQuestion entity = questionMapper.toEntity(dto);
        return questionMapper.toDTO(questionRepo.save(entity));
    }

    public void delete(Integer id) {
        questionRepo.delete(orThrow(questionRepo.findById(id), "Pregunta"));
    }
}