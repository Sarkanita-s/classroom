package com.edutech.courses.mapper;

import com.edutech.common.dto.CourseContentDTO;
import com.edutech.courses.entity.CourseContent;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseContentMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "courseId", target = "courseId")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "contentType", target = "contentType")
    @Mapping(source = "url", target = "url")
    @Mapping(source = "orderIndex", target = "orderIndex")
    CourseContentDTO toDTO(CourseContent entity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "courseId", target = "courseId")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "contentType", target = "contentType")
    @Mapping(source = "url", target = "url")
    @Mapping(source = "orderIndex", target = "orderIndex")
    CourseContent toEntity(CourseContentDTO dto);
}