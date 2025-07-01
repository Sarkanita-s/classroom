package com.edutech.grades.controller;

import com.edutech.grades.dto.CourseQuizDTO;
import com.edutech.grades.service.CourseQuizService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course-quizzes")
public class CourseQuizController {

    @Autowired
    private CourseQuizService courseQuizService;

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