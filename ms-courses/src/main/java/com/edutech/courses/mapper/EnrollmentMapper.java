package com.edutech.courses.mapper;

import com.edutech.common.dto.EnrollmentDTO;
import com.edutech.courses.entity.Enrollment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "studentId", target = "studentId")
    @Mapping(source = "course.id", target = "courseId")
    @Mapping(source = "enrolledAt", target = "enrolledAt")
    @Mapping(source = "status", target = "status")
    EnrollmentDTO toDTO(Enrollment entity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "studentId", target = "studentId")
    @Mapping(source = "courseId", target = "course.id")
    @Mapping(source = "enrolledAt", target = "enrolledAt")
    @Mapping(source = "status", target = "status")
    Enrollment toEntity(EnrollmentDTO dto);

}