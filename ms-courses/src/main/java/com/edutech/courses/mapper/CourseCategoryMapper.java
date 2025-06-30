package com.edutech.courses.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.edutech.common.dto.CourseCategoryDTO;
import com.edutech.courses.entity.CourseCategory;

@Mapper(componentModel = "spring")
public interface CourseCategoryMapper {
    
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    CourseCategoryDTO toDTO(CourseCategory entity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    CourseCategory toEntity(CourseCategoryDTO dto);
}
