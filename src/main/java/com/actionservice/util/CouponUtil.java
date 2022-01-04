package com.actionservice.util;

import com.actionservice.model.Coupon;
import com.actionservice.model.dto.telegram.CouponDto;

import java.util.List;
import java.util.stream.Collectors;

public class CouponUtil {


    public static List<CouponDto> toDtoS(List<Coupon> coupons) {
        return coupons.stream().map(CouponUtil::toDto)
                .collect(Collectors.toList());
    }

    public static CouponDto toDto(Coupon coupon) {
        var dto = new CouponDto();
        dto.setId(coupon.getId());
        dto.setAdmitadId(coupon.getAdmitadId());
        dto.setName(coupon.getName());
        dto.setStatus(coupon.getStatus());
        dto.setPartner(coupon.getPartner());
        dto.setDescription(coupon.getDescription());
        dto.setRegions(coupon.getRegions());
        dto.setDiscount(coupon.getDiscount());
        dto.setSpecies(coupon.getSpecies());
        dto.setPromocode(coupon.getPromocode());
        dto.setFramesetLink(coupon.getFramesetLink());
        dto.setGotoLink(coupon.getGotoLink());
        dto.setShortName(coupon.getShortName());
        dto.setDateStart(coupon.getDateStart());
        dto.setDateEnd(coupon.getDateEnd());
        dto.setImageUrl(coupon.getImageUrl());
        dto.setLastUpdate(coupon.getLastUpdate());
        return dto;
    }
}
