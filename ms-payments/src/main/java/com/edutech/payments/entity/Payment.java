package com.edutech.payments.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "course_id")
    private Integer courseId;

    @NotNull
    @Column(name = "amount", nullable = false, precision = 15, scale = 3)
    private BigDecimal amount;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "payment_date", nullable = false)
    private Instant paymentDate;

    @Size(max = 100)
    @NotNull
    @Column(name = "payment_method", nullable = false, length = 100)
    private String paymentMethod;

    @Size(max = 200)
    @Column(name = "payment_institution", length = 200)
    private String paymentInstitution;

    @Size(max = 200)
    @Column(name = "transaction_id", length = 200)
    private String transactionId;

    @Size(max = 20)
    @NotNull
    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "discount_coupon_id")
    private Integer discountCouponId;
}