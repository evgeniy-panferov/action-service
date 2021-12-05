package com.actionservice.model.dto;

import com.actionservice.model.Coupon;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Coupons {

    @JsonProperty(value = "results")
    private List<Coupon> coupons;

}
