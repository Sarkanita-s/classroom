package com.edutech.grades.repository;

import com.edutech.grades.entity.CourseQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseQuizRepository extends JpaRepository<CourseQuiz, Integer> {
}