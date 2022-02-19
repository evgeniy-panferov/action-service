package com.actionservice.model.dto.telegram;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
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

    @JsonView(Views.Public.class)
    private Long id;
    @JsonView(Views.Public.class)
    private Long admitadId;
    @JsonView(Views.Public.class)
    private String name;
    @JsonView(Views.Public.class)
    private String imageUrl;
    @JsonView(Views.Public.class)
    private List<CouponDto> coupons;
    @JsonView(Views.Public.class)
    private LocalDateTime lastUpdate;
    @JsonView(Views.Public.class)
    private Set<CategoryDto> categories;
    @JsonView(Views.Public.class)
    private String description;
    @JsonView(Views.Public.class)
    private Boolean exclusive;

}
