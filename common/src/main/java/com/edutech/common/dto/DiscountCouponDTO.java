package com.edutech.common.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class DiscountCouponDTO {

    @NotNull(message = "El ID del cupón es obligatorio.")
    private Integer id;

    @NotBlank(message = "El código del cupón es obligatorio.")
    @Size(max = 50, message = "El código no puede exceder los 50 caracteres.")
    private String code;

    @NotBlank(message = "La descripción del cupón es obligatoria.")
    @Size(max = 800, message = "La descripción no puede exceder los 800 caracteres.")
    private String description;

    @NotNull(message = "Debe especificar el porcentaje de descuento.")
    @DecimalMin(value = "0.01", inclusive = true, message = "El descuento debe ser mayor a 0.")
    @DecimalMax(value = "100.00", inclusive = true, message = "El descuento no puede superar el 100%.")
    private BigDecimal discountPercentage;

    @NotNull(message = "Debe especificar la fecha de inicio de validez del cupón.")
    private LocalDate validFrom;

    @NotNull(message = "Debe especificar la fecha de expiración del cupón.")
    private LocalDate validUntil;

    @NotNull(message = "Debe indicar si el cupón está activo o no.")
    private Boolean isActive;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

}
