package com.edutech.common.dto;

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
}