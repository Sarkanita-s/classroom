package com.edutech.grades.service;

import com.edutech.common.dto.CourseQuizDTO;
import com.edutech.grades.client.CourseClient;
import com.edutech.grades.entity.CourseQuiz;
import com.edutech.grades.mapper.CourseQuizMapper;
import com.edutech.grades.repository.CourseQuizRepository;
import com.edutech.grades.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.edutech.common.exception.ExceptionUtils.orThrow;
import static com.edutech.common.exception.ExceptionUtils.orThrowFeign;

@Service
public class CourseQuizService {

    @Autowired
    private CourseQuizRepository courseQuizRepo;
    
    @Autowired
    private QuizRepository quizRepo;
    
    @Autowired
    private CourseQuizMapper courseQuizMapper;
    
    @Autowired
    private CourseClient courseClient;

    public CourseQuizDTO create(CourseQuizDTO dto) {
        orThrowFeign(dto.getCourseId(), courseClient::findById, "Curso");
        orThrow(quizRepo.findById(dto.getId()), "Quiz");
        
        CourseQuiz entity = courseQuizMapper.toEntity(dto);
        return courseQuizMapper.toDTO(courseQuizRepo.save(entity));
    }

    public void delete(Integer id) {
        courseQuizRepo.delete(orThrow(courseQuizRepo.findById(id), "CourseQuiz"));
    }
}