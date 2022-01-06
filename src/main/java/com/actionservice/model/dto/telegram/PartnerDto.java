package com.actionservice.model.dto.telegram;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Long.class)
public class PartnerDto {

    private Long id;

    private Long admitadId;

    private String name;

    private String imageUrl;

    private List<CouponDto> coupons;

    private LocalDateTime lastUpdate;

    private Set<CategoryDto> categories;

    private String description;

    private Boolean exclusive;

}
