package com.edutech.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.courses.entity.CourseContent;

@Repository
public interface CourseContentRepository extends JpaRepository<CourseContent, Integer> {

}
