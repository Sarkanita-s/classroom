package com.edutech.grades.controller;

import com.edutech.common.dto.CourseQuizDTO;
import com.edutech.grades.service.CourseQuizService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course-quizzes")
@RequiredArgsConstructor
public class CourseQuizController {

    private final CourseQuizService courseQuizService;

    @PostMapping
    public ResponseEntity<CourseQuizDTO> create(@RequestBody @Valid CourseQuizDTO dto) {
        return ResponseEntity.ok(courseQuizService.create(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        courseQuizService.delete(id);
        return ResponseEntity.noContent().build();
    }
}