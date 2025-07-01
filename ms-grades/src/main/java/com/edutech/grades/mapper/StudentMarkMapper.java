package com.edutech.grades.mapper;

import com.edutech.grades.dto.StudentMarkDTO;
import com.edutech.grades.entity.StudentMark;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMarkMapper {
    StudentMarkDTO toDTO(StudentMark entity);
    StudentMark toEntity(StudentMarkDTO dto);
}