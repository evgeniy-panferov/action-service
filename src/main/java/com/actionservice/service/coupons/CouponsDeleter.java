package com.actionservice.service.coupons;

import com.actionservice.repository.coupon.CouponDAOImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class CouponsDeleter {

    private final CouponDAOImpl couponDAO;

    @Transactional
    public void delete() {
        LocalDateTime now = LocalDateTime.now();
        log.info("Delete coupon time - {}", now);
        couponDAO.deleteOverdueCoupon(LocalDateTime.now());
    }
}
