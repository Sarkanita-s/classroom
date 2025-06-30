package com.edutech.courses.controller;

import com.edutech.common.dto.CourseQuizDTO;
import com.edutech.courses.service.CourseQuizService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course-quizzes")
public class CourseQuizController {

    @Autowired
    private CourseQuizService quizService;

    @PostMapping
    public ResponseEntity<CourseQuizDTO> create(@RequestBody @Valid CourseQuizDTO dto) {
        return ResponseEntity.ok(quizService.create(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        quizService.delete(id);
        return ResponseEntity.noContent().build();
    }
}