package com.actionservice.client;

import com.actionservice.model.dto.telegram.CouponDto;
import com.actionservice.model.dto.telegram.PartnerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "telegram-discount-service-client", url = "${external.tg-discount-sevice}")
public interface TelegramDiscountServiceClient {

    @PostMapping("/partners")
    void sendPartner(@RequestBody List<PartnerDto> partners);

    @PostMapping("/coupons")
    void sendCoupons(@RequestBody List<CouponDto> coupons);
}
