package com.actionservice.service.coupons;

import com.actionservice.client.AdmitadContentClient;
import com.actionservice.model.Coupon;
import com.actionservice.model.Partner;
import com.actionservice.repository.coupon.CouponDAOImpl;
import com.actionservice.repository.partner.PartnerDAOImpl;
import com.actionservice.service.WebmasterWebsiteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class CouponService {

    private final PartnerDAOImpl partnerRepository;
    private final AdmitadContentClient admitadContentClient;
    private final CouponDAOImpl couponRepository;
    private final WebmasterWebsiteService webmasterWebsiteService;

    @Transactional
    public void couponUpdate() {
        log.info("Start coupon DB update");
        Map<Long, Partner> partnerByIdDb = partnerRepository.findAll().stream()
                .collect(Collectors.toMap(Partner::getAdmitadId, Function.identity()));

        List<Coupon> admitad = new ArrayList<>();

        partnerByIdDb.keySet().forEach(id -> admitad.addAll(fromAdmitad(id)));

        Map<Long, Coupon> couponByIdDb = couponRepository.findAll().stream()
                .collect(Collectors.toMap(Coupon::getAdmitadId, Function.identity()));

        Map<Long, Coupon> couponByIdAdm = admitad.stream()
                .collect(Collectors.toMap(Coupon::getAdmitadId, Function.identity()));

        Set<Long> idByChangedCoupon = CouponChangeFinder.find(admitad, new ArrayList<>(couponByIdDb.values()));

        idByChangedCoupon.forEach(id ->
                {
                    Coupon couponFromDb = couponByIdDb.get(id);
                    Coupon couponFromAdm = couponByIdAdm.get(id);

                    Long partnerAdmitadId = couponFromAdm.getPartner().getAdmitadId();
                    couponFromAdm.setLastUpdate(LocalDateTime.now());
                    if (couponFromDb != null) {
                        couponFromAdm.setId(couponFromDb.getId());
                        couponFromAdm.setPartner(partnerByIdDb.get(partnerAdmitadId));
                        couponRepository.update(couponFromAdm, id);
                        log.info("Update coupon by id - {}, coupon - {}, partnerId - {}", id, couponByIdAdm, couponFromAdm.getPartner().getId());
                    } else {
                        log.info("Save coupon by id - {}, coupon - {}, partnerId - {}", id, couponByIdAdm, couponFromAdm.getPartner().getId());
                        couponFromAdm.setPartner(partnerByIdDb.get(partnerAdmitadId));
                        couponRepository.save(couponFromAdm);
                    }
                }
        );
    }

    private List<Coupon> fromAdmitad(Long id) {
        return admitadContentClient.couponsForSite(
                webmasterWebsiteService.getWebsiteId("YouPromocodeBot"), id).getCoupons();
    }
}