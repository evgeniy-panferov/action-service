package com.actionservice.service.dbrefresh;

import com.actionservice.client.AdmitadContentClient;
import com.actionservice.model.dto.Coupons;
import com.actionservice.repository.coupon.CouponDAOImpl;
import com.actionservice.repository.partner.PartnerDAOImpl;
import com.actionservice.service.WebmasterWebsiteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@AllArgsConstructor
public class DataBaseCouponRefresh {

    private final PartnerDAOImpl partnerRepository;
    private final AdmitadContentClient admitadContentClient;
    private final CouponDAOImpl couponRepository;
    private final WebmasterWebsiteService webmasterWebsiteService;

    protected void dataBaseRefresh() {
        partnerRepository.findAll()
                .forEach(partner -> {
                    Coupons coupons = admitadContentClient.couponsForSite(
                            webmasterWebsiteService.getWebsiteId("YouPromocodeBot"),
                            partner.getAdmitadId());
                    coupons.getCoupons().forEach(coupon -> {
                        if (coupon.getDateEnd() == null) {
                            coupon.setDateEnd(LocalDateTime.of(4000, 10, 20, 10, 10));
                        }
                        coupon.setLastUpdate(LocalDateTime.now());
                        coupon.addPartner(partner);
                    });
                    couponRepository.saveAll(coupons.getCoupons());
                });

        log.info("DataBaseActionRefresh DataBaseActionRefresh");
    }
}