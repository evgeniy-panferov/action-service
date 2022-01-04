package com.actionservice.http;

import com.actionservice.model.Coupon;
import com.actionservice.model.dto.telegram.CouponDto;
import com.actionservice.repository.coupon.CouponDAOImpl;
import com.actionservice.util.CouponUtil;
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

    @GetMapping("/{partnerId}")
    public List<CouponDto> getCouponsByPartnerId(@PathVariable Long partnerId) {
        return CouponUtil.toDtoS(couponDAO.findCouponByPartnerId(partnerId));
    }

    //TODO findBycouponCategory
//    @GetMapping("/{categoryId}")
//    public List<Coupon> getCouponByCategoryId(@PathVariable Long categoryId){
//        return couponDAO.findCouponByCategoryId(categoryId);
//    }
}
