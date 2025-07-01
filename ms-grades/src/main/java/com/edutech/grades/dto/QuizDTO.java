package com.edutech.grades.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class QuizDTO {
    private Integer id;
    private String title;
    private String description;
    private Integer courseId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer timeLimitMinutes;
    private Integer maxScore;
    private Boolean isPublished;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

}