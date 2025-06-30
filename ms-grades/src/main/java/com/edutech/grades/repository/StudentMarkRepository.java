package com.edutech.grades.repository;

import com.edutech.grades.entity.StudentMark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMarkRepository extends JpaRepository<StudentMark, Integer> {
}