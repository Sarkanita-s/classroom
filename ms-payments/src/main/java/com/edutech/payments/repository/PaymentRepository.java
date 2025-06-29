package com.edutech.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.payments.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {


}
