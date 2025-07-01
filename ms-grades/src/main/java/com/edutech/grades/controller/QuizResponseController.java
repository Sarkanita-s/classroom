package com.edutech.grades.controller;

import com.edutech.common.dto.QuizResponseDTO;
import com.edutech.grades.service.QuizResponseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz-responses")
public class QuizResponseController {

    @Autowired
    private QuizResponseService responseService;

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