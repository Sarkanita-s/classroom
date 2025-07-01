package com.edutech.grades.mapper;

import com.edutech.grades.dto.QuizResponseDTO;
import com.edutech.grades.entity.QuizResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuizResponseMapper {
    QuizResponseDTO toDTO(QuizResponse entity);
    QuizResponse toEntity(QuizResponseDTO dto);
}