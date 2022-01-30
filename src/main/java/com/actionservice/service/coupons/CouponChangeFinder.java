package com.actionservice.service.coupons;

import com.actionservice.model.Coupon;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CouponChangeFinder {

    static Set<Long> find(List<Coupon> admitad, List<Coupon> db) {
        log.info("CouponChangeFinder find - {}, {}", admitad, db);
        List<CheckSumCoupon> admCoupons = admitad.stream()
                .map(CheckSumCoupon::convert)
                .collect(Collectors.toList());

        List<CheckSumCoupon> dbCoupon = db.stream()
                .map(CheckSumCoupon::convert)
                .collect(Collectors.toList());

        admCoupons.removeAll(dbCoupon);

        Set<Long> changedCoupon = admCoupons.stream()
                .map(CheckSumCoupon::getAdmitadId)
                .collect(Collectors.toSet());

        return changedCoupon;
    }

}
