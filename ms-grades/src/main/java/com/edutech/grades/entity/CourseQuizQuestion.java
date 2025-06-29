package com.edutech.grades.entity;

import java.time.Instant;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="course_quiz_question")
public class CourseQuizQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    private CourseQuiz quiz;

    @Column(name = "question_text", length = 800)
    private String questionText;

    @Column(name = "option_a", length = 800)
    private String optionA;

    @Column(name = "option_b", length = 800)
    private String optionB;

    @Column(name = "option_c", length = 800)
    private String optionC;

    @Column(name = "option_d", length = 800)
    private String optionD;

    @Column(name = "option_e", length = 800)
    private String optionE;

    @Column(name = "correct_answer", length = 800)
    private String correctAnswer;

    @Column(name = "correct_option", length = 1)
    private String correctOption;

    @Column(name = "order_index", nullable = false)
    private Integer orderIndex;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

}
