package com.actionservice.model.dto.telegram;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Getter
@Setter
public class PartnerDto {

    private Long id;

    private Long admitadId;

    private String name;

    private String imageUrl;

    @JsonManagedReference
    private List<CouponDto> coupons;

    private LocalDateTime lastUpdate;

    @JsonManagedReference
    private Set<CategoryDto> categories;

    private String description;

    private Boolean exclusive;

}
