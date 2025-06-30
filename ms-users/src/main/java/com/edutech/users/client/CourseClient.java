package com.edutech.users.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.edutech.common.dto.CourseDTO;

@FeignClient(name = "ms-courses")
public interface CourseClient {
    
    @GetMapping("/api/courses/{id}")
    CourseDTO findCourseById(@PathVariable("id") Integer id);
    
    @GetMapping("/api/courses/user/{userId}")
    List<CourseDTO> findCoursesByInstructor(@PathVariable("userId") Integer userId);
}