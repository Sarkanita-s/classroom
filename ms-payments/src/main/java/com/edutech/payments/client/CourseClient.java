package com.edutech.payments.client;

import com.edutech.common.dto.CourseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-courses")
public interface CourseClient {
    @GetMapping("/api/courses/{id}")
    CourseDTO findById(@PathVariable Integer id);
}