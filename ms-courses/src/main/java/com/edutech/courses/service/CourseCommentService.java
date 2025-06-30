package com.edutech.courses.service;

import com.edutech.common.dto.CourseCommentDTO;
import com.edutech.courses.client.UserClient;
import com.edutech.courses.entity.CourseComment;
import com.edutech.courses.mapper.CourseCommentMapper;
import com.edutech.courses.repository.CourseCommentRepository;
import com.edutech.courses.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.edutech.common.exception.ExceptionUtils.orThrow;
import static com.edutech.common.exception.ExceptionUtils.orThrowFeign;

@Service
public class CourseCommentService {

    @Autowired
    private CourseCommentRepository commentRepo;
    
    @Autowired
    private CourseRepository courseRepo;
    
    @Autowired
    private CourseCommentMapper commentMapper;
    
    @Autowired
    private UserClient userClient;

    public CourseCommentDTO create(CourseCommentDTO dto) {
        orThrow(courseRepo.findById(dto.getCourseId()), "Curso");
        orThrowFeign(dto.getUserId(), userClient::findById, "Usuario");
        
        CourseComment entity = commentMapper.toEntity(dto);
        return commentMapper.toDTO(commentRepo.save(entity));
    }

    public void delete(Integer id) {
        commentRepo.delete(orThrow(commentRepo.findById(id), "Comentario"));
    }
}