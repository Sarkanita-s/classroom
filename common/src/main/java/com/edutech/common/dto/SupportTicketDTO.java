package com.edutech.common.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;

@Data
public class SupportTicketDTO {

    @NotNull(message = "El ID del ticket es obligatorio.")
    private Integer id;

    @NotNull(message = "Debe especificar el ID del usuario que crea el ticket.")
    private Integer userId;

    private Integer supportUserId;

    @NotBlank(message = "El asunto del ticket es obligatorio.")
    @Size(max = 200, message = "El asunto no puede superar los 200 caracteres.")
    private String subject;

    @NotBlank(message = "La descripción del ticket es obligatoria.")
    @Size(max = 800, message = "La descripción no puede superar los 800 caracteres.")
    private String description;

    @NotBlank(message = "El estado del ticket es obligatorio.")
    @Size(max = 20, message = "El estado no puede superar los 20 caracteres.")
    private String status;

    @NotNull(message = "La fecha de creación del ticket es obligatoria.")
    private Instant createdAt;

    private Instant closedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSupportUserId() {
        return supportUserId;
    }

    public void setSupportUserId(Integer supportUserId) {
        this.supportUserId = supportUserId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(Instant closedAt) {
        this.closedAt = closedAt;
    }

}
