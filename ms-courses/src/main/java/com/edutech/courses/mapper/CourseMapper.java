package com.edutech.courses.mapper;

import com.edutech.common.dto.CourseDTO;
import com.edutech.courses.entity.Course;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "categoryId", target = "categoryId")
    @Mapping(source = "managerId", target = "managerId")
    @Mapping(source = "instructorId", target = "instructorId")
    @Mapping(source = "publishDate", target = "publishDate")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "image", target = "image")
    @Mapping(source = "status", target = "status")
    CourseDTO toDTO(Course entity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "categoryId", target = "categoryId")
    @Mapping(source = "managerId", target = "managerId")
    @Mapping(source = "instructorId", target = "instructorId")
    @Mapping(source = "publishDate", target = "publishDate")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "image", target = "image")
    @Mapping(source = "status", target = "status")
    Course toEntity(CourseDTO dto);
}