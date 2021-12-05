package com.actionservice.repository.coupon;

import com.actionservice.model.Coupon;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponDao {

    List<Coupon> findAll();

    List<Coupon> saveAll(List<Coupon> coupons);

    Coupon save(Coupon coupon);
}
