package com.edutech.grades.controller;

import com.edutech.common.dto.QuizDTO;
import com.edutech.grades.service.QuizService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
@RequiredArgsConstructor
public class QuizController {
    private QuizService quizService;

    @GetMapping
    public ResponseEntity<List<QuizDTO>> findAll() {
        return ResponseEntity.ok(quizService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(quizService.findById(id));
    }

    @PostMapping
    public ResponseEntity<QuizDTO> create(@RequestBody @Valid QuizDTO dto) {
        return ResponseEntity.ok(quizService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuizDTO> update(@PathVariable Integer id, @RequestBody @Valid QuizDTO dto) {
        return ResponseEntity.ok(quizService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        quizService.delete(id);
        return ResponseEntity.noContent().build();
    }
}