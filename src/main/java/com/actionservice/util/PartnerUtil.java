package com.actionservice.util;

import com.actionservice.model.Partner;
import com.actionservice.model.dto.telegram.PartnerDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PartnerUtil {

    public static List<PartnerDto> toDtos(List<Partner> partners) {
        return partners.stream().map(PartnerUtil::toDto)
                .collect(Collectors.toList());
    }

    public static PartnerDto toDto(Partner partner) {
        var dto = new PartnerDto();

        dto.setId(partner.getId());

        dto.setAdmitadId(partner.getAdmitadId());

        dto.setName(partner.getName());

        dto.setImageUrl(partner.getImageUrl());

        dto.setCoupons(CouponUtil.toDtosAndSetPartner(partner.getCoupons(), dto));

        dto.setLastUpdate(partner.getLastUpdate());

        dto.setCategories(CategoryUtil.toDtos(partner.getCategories()));

        dto.setDescription(partner.getDescription());

        dto.setExclusive(partner.getExclusive());

        return dto;
    }

}
