package com.actionservice.repository.coupon;

import com.actionservice.model.Coupon;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@AllArgsConstructor
public class CouponDAOImpl implements CouponDao {

    private final CrudCouponRepository crudCouponRepository;

    @Override
    public List<Coupon> findAll() {
        log.info("CouponRepositoryImpl findAll");
        return crudCouponRepository.findAll();
    }

    @Override
    public List<Coupon> saveAll(List<Coupon> coupons) {
        log.info("CouponRepositoryImpl saveAll - {}", coupons);
        return crudCouponRepository.saveAll(coupons);
    }

    @Override
    public Coupon save(Coupon coupon) {
        return crudCouponRepository.save(coupon);
    }
}
