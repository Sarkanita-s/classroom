package com.edutech.payments.mapper;

import org.mapstruct.Mapper;

import com.edutech.common.dto.DiscountCouponDTO;
import com.edutech.payments.entity.DiscountCoupon;

@Mapper(componentModel = "spring")
public interface DiscountCouponMapper {
    DiscountCouponDTO toDTO(DiscountCoupon entity);
    DiscountCoupon toEntity(DiscountCouponDTO dto);
}
