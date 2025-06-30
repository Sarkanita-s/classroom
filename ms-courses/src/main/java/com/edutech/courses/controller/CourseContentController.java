package com.edutech.courses.controller;

import com.edutech.common.dto.CourseContentDTO;
import com.edutech.courses.service.CourseContentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course-contents")
public class CourseContentController {

    @Autowired
    private CourseContentService contentService;

    @PostMapping
    public ResponseEntity<CourseContentDTO> create(@RequestBody @Valid CourseContentDTO dto) {
        return ResponseEntity.ok(contentService.create(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        contentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}