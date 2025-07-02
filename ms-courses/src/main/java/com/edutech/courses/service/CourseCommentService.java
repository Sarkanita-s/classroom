package com.edutech.courses.service;

import com.edutech.common.dto.CourseCommentDTO;
import com.edutech.courses.client.UserClient;
import com.edutech.courses.entity.CourseComment;
import com.edutech.courses.mapper.CourseCommentMapper;
import com.edutech.courses.repository.CourseCommentRepository;
import com.edutech.courses.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.edutech.common.exception.ExceptionUtils.orThrow;
import static com.edutech.common.exception.ExceptionUtils.orThrowFeign;

@Service
@RequiredArgsConstructor
public class CourseCommentService {

    private final CourseCommentRepository commentRepo;
    private final CourseRepository courseRepo;
    private final CourseCommentMapper commentMapper;
    private final UserClient userClient;

    public List<CourseCommentDTO> findAll() {
        return commentRepo.findAll().stream().map(commentMapper::toDTO).toList();
    }

    public CourseCommentDTO findById(Integer id) {
        return commentMapper.toDTO(orThrow(commentRepo.findById(id), "Comentario"));
    }

    public CourseCommentDTO create(CourseCommentDTO dto) {
        orThrow(courseRepo.findById(dto.getCourseId()), "Curso");
        orThrowFeign(dto.getUserId(), userClient::findById, "Usuario");
        
        CourseComment entity = commentMapper.toEntity(dto);
        return commentMapper.toDTO(commentRepo.save(entity));
    }

    public CourseCommentDTO update(Integer id, CourseCommentDTO dto) {
        orThrow(commentRepo.findById(id), "Comentario");
        return saveDTO(dto, id);
    }

    public void delete(Integer id) {
        commentRepo.delete(orThrow(commentRepo.findById(id), "Comentario"));
    }

    private CourseCommentDTO saveDTO(CourseCommentDTO dto, Integer id) {
        CourseComment entity = commentMapper.toEntity(dto);
        if (id != null) entity.setId(id);
        return commentMapper.toDTO(commentRepo.save(entity));
    }
}