package com.actionservice.http;

import com.actionservice.model.Coupon;
import com.actionservice.repository.coupon.CouponDAOImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coupons")
@RequiredArgsConstructor
public class CouponCtrl {

    private final CouponDAOImpl couponDAO;

    @GetMapping("partner/{id}")
    public List<Coupon> getCouponsByPartnerId(@PathVariable Long id){
        return couponDAO.findCouponByPartnerId(id);
    }
}
