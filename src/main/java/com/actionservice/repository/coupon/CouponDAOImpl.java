package com.actionservice.repository.coupon;

import com.actionservice.model.Coupon;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Repository
@AllArgsConstructor
public class CouponDAOImpl implements CouponDao {

    private final CrudCouponRepository crudCouponRepository;

    @Override
    @Transactional
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
    public List<Coupon> findCouponByPartnerId(Long partnerId) {
        log.info("CouponRepositoryImpl findCouponByPartnerId - {}", partnerId);
        return crudCouponRepository.findCouponByPartnerId(partnerId);
    }

    @Override
    public Coupon save(Coupon coupon) {
        log.info("CouponRepositoryImpl save - {}", coupon);
        return crudCouponRepository.save(coupon);
    }

    @Override
    public void update(Coupon coupon, Long id) {
        crudCouponRepository.update(coupon,id);
        log.info("CouponRepositoryImpl update by Id - {} , - {}", coupon, id);
    }
}
