package com.edutech.payments.service;

import com.edutech.common.dto.PaymentDTO;
import com.edutech.payments.client.UserClient;
import com.edutech.payments.entity.Payment;
import com.edutech.payments.mapper.PaymentMapper;
import com.edutech.payments.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.edutech.common.exception.ExceptionUtils.orThrow;
import static com.edutech.common.exception.ExceptionUtils.orThrowFeign;

@Service
@RequiredArgsConstructor
public class PaymentService {
    
    @Autowired
    private PaymentRepository paymentRepo;
    
    @Autowired
    private PaymentMapper paymentMapper;
    
    @Autowired
    private UserClient userClient;

    public List<PaymentDTO> findAll() {
        return paymentRepo.findAll().stream()
                .map(paymentMapper::toDTO)
                .toList();
    }

    public PaymentDTO findById(Integer id) {
        return paymentMapper.toDTO(
                orThrow(paymentRepo.findById(id), "Pago")
        );
    }

    public PaymentDTO create(PaymentDTO dto) {
        // Validar que el usuario existe
        orThrowFeign(dto.getUserId(), userClient::findById, "Usuario");
        
        // No validamos courseId porque no existe en el DTO
        Payment payment = paymentMapper.toEntity(dto);
        return paymentMapper.toDTO(paymentRepo.save(payment));
    }

    public PaymentDTO update(Integer id, PaymentDTO dto) {
    Payment existing = orThrow(paymentRepo.findById(id), "Pago");
    
    // Actualización manual de campos
    existing.setAmount(dto.getAmount());
    existing.setPaymentDate(dto.getPaymentDate());
    existing.setPaymentMethod(dto.getPaymentMethod());
    existing.setPaymentInstitution(dto.getPaymentInstitution());
    existing.setTransactionId(dto.getTransactionId());
    existing.setStatus(dto.getStatus());
    
    return paymentMapper.toDTO(paymentRepo.save(existing));
}

    public void delete(Integer id) {
        paymentRepo.delete(orThrow(paymentRepo.findById(id), "Pago"));
    }
}