package com.actionservice.util;

import com.actionservice.model.Partner;
import com.actionservice.model.dto.telegram.PartnerDto;

import java.util.List;
import java.util.stream.Collectors;

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

        dto.setCoupons(partner.getCoupons());

        dto.setLastUpdate(partner.getLastUpdate());

        dto.setCategories(partner.getCategories());

        dto.setDescription(partner.getDescription());

        dto.setExclusive(partner.getExclusive());
        return dto;
    }

}
