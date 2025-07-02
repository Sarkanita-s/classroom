package com.edutech.courses.service;

import com.edutech.common.dto.CourseContentDTO;
import com.edutech.courses.entity.CourseContent;
import com.edutech.courses.mapper.CourseContentMapper;
import com.edutech.courses.repository.CourseContentRepository;
import com.edutech.courses.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.edutech.common.exception.ExceptionUtils.orThrow;

@Service
@RequiredArgsConstructor
public class CourseContentService {

    private final CourseContentRepository contentRepo;
    private final CourseRepository courseRepo;
    private final CourseContentMapper contentMapper;

    public List<CourseContentDTO> findAll() {
        return contentRepo.findAll().stream().map(contentMapper::toDTO).toList();
    }

    public CourseContentDTO findById(Integer id) {
        return contentMapper.toDTO(orThrow(contentRepo.findById(id), "Contenido"));
    }

    public CourseContentDTO create(CourseContentDTO dto) {
        orThrow(courseRepo.findById(dto.getCourseId()), "Curso");
        
        CourseContent entity = contentMapper.toEntity(dto);
        return contentMapper.toDTO(contentRepo.save(entity));
    }

    public CourseContentDTO update(Integer id, CourseContentDTO dto) {
        orThrow(contentRepo.findById(id), "Contenido");
        return saveDTO(dto, id);
    }

    public void delete(Integer id) {
        contentRepo.delete(orThrow(contentRepo.findById(id), "Contenido"));
    }

    private CourseContentDTO saveDTO(CourseContentDTO dto, Integer id) {
        CourseContent entity = contentMapper.toEntity(dto);
        if (id != null) entity.setId(id);
        return contentMapper.toDTO(contentRepo.save(entity));
    }
}