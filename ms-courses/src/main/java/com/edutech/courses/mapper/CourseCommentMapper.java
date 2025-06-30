package com.edutech.courses.mapper;

import com.edutech.common.dto.CourseCommentDTO;
import com.edutech.courses.entity.CourseComment;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseCommentMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "courseId", target = "courseId")
    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "commentText", target = "commentText")
    @Mapping(source = "rating", target = "rating")
    @Mapping(source = "createdAt", target = "createdAt")
    CourseCommentDTO toDTO(CourseComment entity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "courseId", target = "courseId")
    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "commentText", target = "commentText")
    @Mapping(source = "rating", target = "rating")
    @Mapping(source = "createdAt", target = "createdAt")
    CourseComment toEntity(CourseCommentDTO dto);
}