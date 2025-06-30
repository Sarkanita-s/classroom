package com.edutech.courses.controller;

import com.edutech.common.dto.CourseQuizQuestionDTO;
import com.edutech.courses.service.CourseQuizQuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course-quiz-questions")
public class CourseQuizQuestionController {

    @Autowired
    private CourseQuizQuestionService questionService;

    @PostMapping
    public ResponseEntity<CourseQuizQuestionDTO> create(@RequestBody @Valid CourseQuizQuestionDTO dto) {
        return ResponseEntity.ok(questionService.create(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        questionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}