package com.edutech.grades.mapper;

import com.edutech.common.dto.QuizDTO;
import com.edutech.grades.entity.Quiz;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuizMapper {
    QuizDTO toDTO(Quiz entity);
    Quiz toEntity(QuizDTO dto);
}