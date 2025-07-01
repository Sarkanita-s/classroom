package com.edutech.grades.mapper;

import com.edutech.common.dto.CourseQuizQuestionDTO;
import com.edutech.grades.entity.CourseQuizQuestion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseQuizQuestionMapper {
    CourseQuizQuestionDTO toDTO(CourseQuizQuestion entity);
    CourseQuizQuestion toEntity(CourseQuizQuestionDTO dto);
}