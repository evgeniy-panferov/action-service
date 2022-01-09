package com.actionservice.repository.coupon;

import com.actionservice.model.Coupon;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Repository
@AllArgsConstructor
public class CouponDAOImpl implements CouponDao {

    private final CrudCouponRepository crudCouponRepository;

    @Override
    @Transactional
    public List<Coupon> findAll() {
        log.info("CouponRepositoryImpl findAll");
        //TODO distinct can be delete
        return crudCouponRepository.findAll().stream()
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<Coupon> saveAll(List<Coupon> coupons) {
        log.info("CouponRepositoryImpl saveAll - {}", coupons);
        return crudCouponRepository.saveAll(coupons);
    }

    @Override
    public List<Coupon> findCouponByPartnerId(Long partnerId) {
        log.info("CouponRepositoryImpl findCouponByPartnerId - {}", partnerId);
        //TODO distinct can be delete
        return crudCouponRepository.findCouponByPartnerId(partnerId).stream()
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public Coupon save(Coupon coupon) {
        log.info("CouponRepositoryImpl save - {}", coupon);
        return crudCouponRepository.save(coupon);
    }

    @Override
    public void update(Coupon coupon, Long id) {
        crudCouponRepository.update(coupon, id);
        log.info("CouponRepositoryImpl update by Id - {} , - {}", coupon, id);
    }

    @Override
    public void deleteOverdueCoupon(LocalDateTime dateTime) {
        log.info("CouponRepositoryImpl deleteOverdueCoupon time - {}", dateTime);
        crudCouponRepository.deleteOverdueCoupon(dateTime);
    }
}
