package com.edutech.payments.service;

import com.edutech.common.dto.DiscountCouponDTO;
import com.edutech.payments.entity.DiscountCoupon;
import com.edutech.payments.mapper.DiscountCouponMapper;
import com.edutech.payments.repository.DiscountCouponRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

import static com.edutech.common.exception.ExceptionUtils.orThrow;

@Service
@RequiredArgsConstructor
public class DiscountCouponService {
    
    private final DiscountCouponRepository couponRepo;
    private final DiscountCouponMapper couponMapper;

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
        orThrow(couponRepo.findById(id), "Cupón de descuento");
        return saveDTO(dto, id);
    }

    public void delete(Integer id) {
        couponRepo.delete(orThrow(couponRepo.findById(id), "Cupón de descuento"));
    }

    private DiscountCouponDTO saveDTO(DiscountCouponDTO dto, Integer id) {
        DiscountCoupon entity = couponMapper.toEntity(dto);
        if (id != null) entity.setId(id);
        return couponMapper.toDTO(couponRepo.save(entity));
    }
}