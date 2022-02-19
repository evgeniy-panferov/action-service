package com.actionservice.client;

import com.actionservice.config.Views;
import com.actionservice.model.dto.telegram.CouponDto;
import com.actionservice.model.dto.telegram.PartnerDto;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "telegram-discount-service-client", url = "${external.tg-discount-sevice}")
public interface TelegramDiscountServiceClient {

    @PostMapping("/partners")
    void sendPartner(@RequestBody @JsonView(Views.Public.class) List<PartnerDto> partners);

    @PostMapping("/coupons")
    void sendCoupons(@RequestBody @JsonView(Views.Public.class) List<CouponDto> coupons);
}
