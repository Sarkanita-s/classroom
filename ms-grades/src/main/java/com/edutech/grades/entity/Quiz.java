package com.edutech.grades.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "course_id", nullable = false)
    private Integer courseId;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    @Column(name = "time_limit_minutes", nullable = false)
    private Integer timeLimitMinutes;

    @Column(name = "max_score", nullable = false)
    private Integer maxScore;

    @Column(name = "is_published", nullable = false)
    private Boolean isPublished = false;

    public void setId(Integer id) {
        this.id = id;
    }
}