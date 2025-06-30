package com.edutech.common.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;

@Data
public class EnrollmentDTO {

    @NotNull(message = "El ID de la matrícula es obligatorio.")
    private Integer id;

    @NotNull(message = "Debe especificar el ID del estudiante.")
    private Integer studentId;

    @NotNull(message = "Debe especificar el ID del curso.")
    private Integer courseId;

    @NotNull(message = "La fecha de inscripción es obligatoria.")
    private Instant enrolledAt;

    @NotBlank(message = "El estado de la matrícula es obligatorio.")
    @Size(max = 20, message = "El estado no puede exceder los 20 caracteres.")
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Instant getEnrolledAt() {
        return enrolledAt;
    }

    public void setEnrolledAt(Instant enrolledAt) {
        this.enrolledAt = enrolledAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
