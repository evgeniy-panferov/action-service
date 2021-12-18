package com.actionservice.repository.coupon;

import com.actionservice.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudCouponRepository extends JpaRepository<Coupon, Long> {
}
