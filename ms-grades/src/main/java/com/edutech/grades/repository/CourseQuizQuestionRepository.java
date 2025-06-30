package com.edutech.grades.repository;

import com.edutech.grades.entity.CourseQuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseQuizQuestionRepository extends JpaRepository<CourseQuizQuestion, Integer> {
}