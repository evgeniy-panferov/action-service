package com.actionservice.repository.coupon;

import com.actionservice.model.Coupon;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponDao {

    List<Coupon> findAll();

    List<Coupon> saveAll(List<Coupon> coupons);

    List<Coupon> findCouponByPartnerId(Long partnerId);

    Coupon save(Coupon coupon);

    void update(Coupon coupon, Long id);

//    List<Coupon> findCouponByCategoryId(Long categoryId);
}
