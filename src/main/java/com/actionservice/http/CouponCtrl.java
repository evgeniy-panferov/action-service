package com.actionservice.http;

import com.actionservice.model.dto.telegram.CouponDto;
import com.actionservice.repository.coupon.CouponDAOImpl;
import com.actionservice.util.CouponUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/coupons")
@RequiredArgsConstructor
public class CouponCtrl {

    private final CouponDAOImpl couponDAO;

    @GetMapping("/{partnerId}")
    public ResponseEntity<List<CouponDto>> getCouponsByPartnerId(@PathVariable Long partnerId) {
        log.info("CouponCtrl getCouponsByPartnerId, partnerId - {}", partnerId);
        return new ResponseEntity<>(CouponUtil.toDtos(couponDAO.findCouponByPartnerId(partnerId)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CouponDto>> getCoupons() {
        log.info("CouponCtrl getCouponsByPartnerId");
        return new ResponseEntity<>(CouponUtil.toDtos(couponDAO.findAll()), HttpStatus.OK);
    }

    //TODO findBycouponCategory
//    @GetMapping("/{categoryId}")
//    public List<Coupon> getCouponByCategoryId(@PathVariable Long categoryId){
//        return couponDAO.findCouponByCategoryId(categoryId);
//    }
}
