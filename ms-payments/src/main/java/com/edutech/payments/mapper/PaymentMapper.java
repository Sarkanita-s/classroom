package com.edutech.payments.mapper;

import org.mapstruct.Mapper;

import com.edutech.common.dto.PaymentDTO;
import com.edutech.payments.entity.Payment;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentDTO toDTO(Payment entity);
    Payment toEntity(PaymentDTO dto);
}
