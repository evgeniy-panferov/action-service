package com.actionservice.repository.coupon;

import com.actionservice.model.Coupon;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
        //TODO distinct can delete
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
        //TODO distinct can delete
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

//    @Override
//    public List<Coupon> findCouponByCategoryId(Long categoryId) {
//        log.info("CouponRepositoryImpl findCouponByCategoryId by Id - {}", categoryId);
    //TODO distinct can delete
//        return crudCouponRepository.findByCategoryId().stream()
//                .distinct()
//                .collect(Collectors.toList());
//    }
}
