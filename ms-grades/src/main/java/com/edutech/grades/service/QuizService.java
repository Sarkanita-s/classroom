package com.edutech.grades.service;

import com.edutech.common.dto.QuizDTO;
import com.edutech.grades.entity.Quiz;
import com.edutech.grades.mapper.QuizMapper;
import com.edutech.grades.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.edutech.common.exception.ExceptionUtils.orThrow;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepo;
    private final QuizMapper quizMapper;

    public List<QuizDTO> findAll() {
        return quizRepo.findAll().stream().map(quizMapper::toDTO).toList();
    }

    public QuizDTO findById(Integer id) {
        return quizMapper.toDTO(orThrow(quizRepo.findById(id), "Quiz"));
    }

    public QuizDTO create(QuizDTO dto) {
        Quiz entity = quizMapper.toEntity(dto);
        return quizMapper.toDTO(quizRepo.save(entity));
    }

    public QuizDTO update(Integer id, QuizDTO dto) {
        orThrow(quizRepo.findById(id), "Quiz");
        return saveDTO(dto, id);
    }

    public void delete(Integer id) {
        quizRepo.delete(orThrow(quizRepo.findById(id), "Quiz"));
    }

    private QuizDTO saveDTO(QuizDTO dto, Integer id) {
        Quiz entity = quizMapper.toEntity(dto);
        if (id != null) entity.setId(id);
        return quizMapper.toDTO(quizRepo.save(entity));
    }
}