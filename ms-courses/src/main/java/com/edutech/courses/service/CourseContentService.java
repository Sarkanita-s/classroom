package com.edutech.courses.service;

import com.edutech.common.dto.CourseContentDTO;
import com.edutech.courses.entity.CourseContent;
import com.edutech.courses.mapper.CourseContentMapper;
import com.edutech.courses.repository.CourseContentRepository;
import com.edutech.courses.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.edutech.common.exception.ExceptionUtils.orThrow;

@Service
public class CourseContentService {

    @Autowired
    private CourseContentRepository contentRepo;
    
    @Autowired
    private CourseRepository courseRepo;
    
    @Autowired
    private CourseContentMapper contentMapper;

    public CourseContentDTO create(CourseContentDTO dto) {
        orThrow(courseRepo.findById(dto.getCourseId()), "Curso");
        
        CourseContent entity = contentMapper.toEntity(dto);
        return contentMapper.toDTO(contentRepo.save(entity));
    }

    public void delete(Integer id) {
        contentRepo.delete(orThrow(contentRepo.findById(id), "Contenido"));
    }
}