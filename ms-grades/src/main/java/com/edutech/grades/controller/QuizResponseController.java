package com.edutech.grades.controller;

import com.edutech.common.dto.QuizResponseDTO;
import com.edutech.grades.service.QuizResponseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz-responses")
@RequiredArgsConstructor
public class QuizResponseController {

    private final QuizResponseService responseService;

    @PostMapping
    public ResponseEntity<QuizResponseDTO> create(@RequestBody @Valid QuizResponseDTO dto) {
        return ResponseEntity.ok(responseService.create(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        responseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}