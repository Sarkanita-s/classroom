package com.edutech.courses.service;

import com.edutech.common.dto.CourseQuizQuestionDTO;
import com.edutech.courses.entity.CourseQuizQuestion;
import com.edutech.courses.mapper.CourseQuizQuestionMapper;
import com.edutech.courses.repository.CourseQuizQuestionRepository;
import com.edutech.courses.repository.CourseQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.edutech.common.exception.ExceptionUtils.orThrow;

@Service
public class CourseQuizQuestionService {

    @Autowired
    private CourseQuizQuestionRepository questionRepo;
    
    @Autowired
    private CourseQuizRepository quizRepo;
    
    @Autowired
    private CourseQuizQuestionMapper questionMapper;

    public CourseQuizQuestionDTO create(CourseQuizQuestionDTO dto) {
        orThrow(quizRepo.findById(dto.getQuizId()), "Quiz");
        
        CourseQuizQuestion entity = questionMapper.toEntity(dto);
        return questionMapper.toDTO(questionRepo.save(entity));
    }

    public void delete(Integer id) {
        questionRepo.delete(orThrow(questionRepo.findById(id), "Pregunta del quiz"));
    }
}