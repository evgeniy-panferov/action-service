package com.actionservice.util;

import com.actionservice.model.Coupon;
import com.actionservice.model.dto.telegram.CouponDto;
import com.actionservice.model.dto.telegram.PartnerDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CouponUtil {


    public static List<CouponDto> toDtos(List<Coupon> coupons) {
        PartnerDto partner = PartnerUtil.toDto(coupons.get(0).getPartner());
        return coupons.stream()
                .map(coupon -> {
                    CouponDto couponDto = toDto(coupon);
                    couponDto.setPartner(partner);
                    return couponDto;
                })
                .collect(Collectors.toList());
    }

    public static CouponDto toDto(Coupon coupon) {
        var dto = new CouponDto();
        dto.setId(coupon.getId());
        dto.setAdmitadId(coupon.getAdmitadId());
        dto.setName(coupon.getName());
        dto.setStatus(coupon.getStatus());
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

    public static List<CouponDto> toDtosAndSetPartner(List<Coupon> coupons, PartnerDto partner) {

        return coupons.stream()
                .distinct()
                .map(coupon -> {
                    CouponDto couponDto = toDto(coupon);
                    couponDto.setPartner(partner);
                    return couponDto;
                })
                .collect(Collectors.toList());
    }
}
