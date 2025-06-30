package com.edutech.courses.controller;

import com.edutech.common.dto.CourseCommentDTO;
import com.edutech.courses.service.CourseCommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course-comments")
public class CourseCommentController {

    @Autowired
    private CourseCommentService commentService;

    @PostMapping
    public ResponseEntity<CourseCommentDTO> create(@RequestBody @Valid CourseCommentDTO dto) {
        return ResponseEntity.ok(commentService.create(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        commentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}