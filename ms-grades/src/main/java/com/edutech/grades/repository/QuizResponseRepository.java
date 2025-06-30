package com.edutech.grades.repository;

import com.edutech.grades.entity.QuizResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizResponseRepository extends JpaRepository<QuizResponse, Integer> {
}