package com.actionservice.model.dto.telegram;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Long.class)
public class CouponDto {
    @JsonView(Views.Public.class)
    private Long id;
    @JsonView(Views.Public.class)
    private Long admitadId;
    @JsonView(Views.Public.class)
    private String name;
    @JsonView(Views.Public.class)
    private String status;
    @JsonView(Views.Public.class)
    private PartnerDto partner;
    @JsonView(Views.Public.class)
    private String description;
    @JsonView(Views.Internal.class)
    private List<String> regions;
    @JsonView(Views.Public.class)
    private String discount;
    @JsonView(Views.Public.class)
    private String species;
    @JsonView(Views.Public.class)
    private String promocode;
    @JsonView(Views.Public.class)
    private String framesetLink;
    @JsonView(Views.Public.class)
    private String gotoLink;
    @JsonView(Views.Public.class)
    private String shortName;
    @JsonView(Views.Public.class)
    private LocalDateTime dateStart;
    @JsonView(Views.Public.class)
    private LocalDateTime dateEnd;
    @JsonView(Views.Public.class)
    private String imageUrl;
    @JsonView(Views.Public.class)
    private LocalDateTime lastUpdate;
}
