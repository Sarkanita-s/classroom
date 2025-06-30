package com.edutech.payments.controller;

import com.edutech.common.dto.PaymentDTO;
import com.edutech.payments.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {
    
    @Autowired
    private PaymentService paymentService;

    // Obtener todos los pagos
    @GetMapping
    public ResponseEntity<List<PaymentDTO>> findAll() {
        return ResponseEntity.ok(paymentService.findAll());
    }

    // Obtener un pago por ID
    @GetMapping("/{id}")
    public ResponseEntity<PaymentDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(paymentService.findById(id));
    }

    // Crear un nuevo pago
    @PostMapping
    public ResponseEntity<PaymentDTO> create(@RequestBody @Valid PaymentDTO dto) {
        return ResponseEntity.ok(paymentService.create(dto));
    }

    // Actualizar un pago existente
    @PutMapping("/{id}")
    public ResponseEntity<PaymentDTO> update(
            @PathVariable Integer id,
            @RequestBody @Valid PaymentDTO dto
    ) {
        return ResponseEntity.ok(paymentService.update(id, dto));
    }

    // Eliminar un pago
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        paymentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}