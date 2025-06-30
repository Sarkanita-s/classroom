package com.edutech.payments.service;

import com.edutech.common.dto.DiscountCouponDTO;
import com.edutech.payments.entity.DiscountCoupon;
import com.edutech.payments.mapper.DiscountCouponMapper;
import com.edutech.payments.repository.DiscountCouponRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.edutech.common.exception.ExceptionUtils.orThrow;

@Service
@RequiredArgsConstructor
public class DiscountCouponService {
    
    @Autowired
    private DiscountCouponRepository couponRepo;
    
    @Autowired
    private DiscountCouponMapper couponMapper;

    public List<DiscountCouponDTO> findAll() {
        return couponRepo.findAll().stream()
                .map(couponMapper::toDTO)
                .toList();
    }

    public DiscountCouponDTO findById(Integer id) {
        return couponMapper.toDTO(
                orThrow(couponRepo.findById(id), "Cupón de descuento")
        );
    }

    // public DiscountCouponDTO findByCode(String code) {
    //     return couponMapper.toDTO(
    //             orThrow(couponRepo.findByCode(code), "Cupón de descuento")
    //     );
    // }
    //
    // NOSE SI ESTO SE UTILIZA AL FINAL PERO NO FUNCIONA, UTILIZAR FIND BY ID

    public DiscountCouponDTO create(DiscountCouponDTO dto) {
        DiscountCoupon coupon = couponMapper.toEntity(dto);
        return couponMapper.toDTO(couponRepo.save(coupon));
    }

    public DiscountCouponDTO update(Integer id, DiscountCouponDTO dto) {
    DiscountCoupon existing = orThrow(couponRepo.findById(id), "Cupón de descuento");
    
    // Actualización manual de campos
    existing.setCode(dto.getCode());
    existing.setDescription(dto.getDescription());
    existing.setDiscountPercentage(dto.getDiscountPercentage());
    existing.setValidFrom(dto.getValidFrom());
    existing.setValidUntil(dto.getValidUntil());
    existing.setIsActive(dto.getIsActive());
    
    return couponMapper.toDTO(couponRepo.save(existing));
}

    public void delete(Integer id) {
        couponRepo.delete(orThrow(couponRepo.findById(id), "Cupón de descuento"));
    }
}