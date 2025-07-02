package com.edutech.payments.service;

import com.edutech.common.dto.PaymentDTO;
import com.edutech.payments.client.UserClient;
import com.edutech.payments.entity.Payment;
import com.edutech.payments.mapper.PaymentMapper;
import com.edutech.payments.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

import static com.edutech.common.exception.ExceptionUtils.orThrow;
import static com.edutech.common.exception.ExceptionUtils.orThrowFeign;

@Service
@RequiredArgsConstructor
public class PaymentService {
    
    private final PaymentRepository paymentRepo;
    private final PaymentMapper paymentMapper;
    private final UserClient userClient;

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
        orThrow(paymentRepo.findById(id), "Pago");
        return saveDTO(dto, id);
    }

    public void delete(Integer id) {
        paymentRepo.delete(orThrow(paymentRepo.findById(id), "Pago"));
    }

    private PaymentDTO saveDTO(PaymentDTO dto, Integer id) {
        Payment entity = paymentMapper.toEntity(dto);
        if (id != null) entity.setId(id);
        return paymentMapper.toDTO(paymentRepo.save(entity));
    }
}