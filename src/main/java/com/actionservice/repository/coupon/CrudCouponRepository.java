package com.actionservice.repository.coupon;

import com.actionservice.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CrudCouponRepository extends JpaRepository<Coupon, Long> {

    @Modifying
    @Transactional
    @Query("update Coupon c set c = :coupon where c.admitadId = :id")
    void update(Coupon coupon, Long id);

    @Query("select c from Coupon c where c.partner.id = :partnerId")
    List<Coupon> findCouponByPartnerId(Long partnerId);

//    @Query("select c from Coupon c where c.partner.categories. =")
//    List<Coupon> findCouponByCategoryId(Long partnerId);
}
