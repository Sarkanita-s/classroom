package com.edutech.grades.controller;

import com.edutech.common.dto.StudentMarkDTO;
import com.edutech.grades.service.StudentMarkService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student-marks")
public class StudentMarkController {

    @Autowired
    private StudentMarkService markService;

    @PostMapping
    public ResponseEntity<StudentMarkDTO> create(@RequestBody @Valid StudentMarkDTO dto) {
        return ResponseEntity.ok(markService.create(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        markService.delete(id);
        return ResponseEntity.noContent().build();
    }
}