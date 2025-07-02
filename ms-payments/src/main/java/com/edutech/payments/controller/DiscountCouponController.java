package com.edutech.payments.controller;

import com.edutech.common.dto.DiscountCouponDTO;
import com.edutech.payments.service.DiscountCouponService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coupons")
@RequiredArgsConstructor
public class DiscountCouponController {
    
    private final DiscountCouponService couponService;

    @GetMapping
    public ResponseEntity<List<DiscountCouponDTO>> findAll() {
        return ResponseEntity.ok(couponService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiscountCouponDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(couponService.findById(id));
    }

    @PostMapping
    public ResponseEntity<DiscountCouponDTO> create(@RequestBody @Valid DiscountCouponDTO dto) {
        return ResponseEntity.ok(couponService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiscountCouponDTO> update(@PathVariable Integer id, @RequestBody @Valid DiscountCouponDTO dto) {
        return ResponseEntity.ok(couponService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        couponService.delete(id);
        return ResponseEntity.noContent().build();
    }

}