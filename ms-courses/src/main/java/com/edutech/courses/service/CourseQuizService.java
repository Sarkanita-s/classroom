package com.edutech.courses.service;

import com.edutech.common.dto.CourseQuizDTO;
import com.edutech.courses.entity.CourseQuiz;
import com.edutech.courses.mapper.CourseQuizMapper;
import com.edutech.courses.repository.CourseQuizRepository;
import com.edutech.courses.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.edutech.common.exception.ExceptionUtils.orThrow;

@Service
public class CourseQuizService {

    @Autowired
    private CourseQuizRepository quizRepo;
    
    @Autowired
    private CourseRepository courseRepo;
    
    @Autowired
    private CourseQuizMapper quizMapper;

    public CourseQuizDTO create(CourseQuizDTO dto) {
        orThrow(courseRepo.findById(dto.getCourseId()), "Curso");
        
        CourseQuiz entity = quizMapper.toEntity(dto);
        return quizMapper.toDTO(quizRepo.save(entity));
    }

    public void delete(Integer id) {
        quizRepo.delete(orThrow(quizRepo.findById(id), "Quiz del curso"));
    }
}