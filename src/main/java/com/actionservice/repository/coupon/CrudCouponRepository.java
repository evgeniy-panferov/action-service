package com.actionservice.repository.coupon;

import com.actionservice.model.Coupon;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CrudCouponRepository extends JpaRepository<Coupon, Long> {

    @EntityGraph(value = "Coupon[regions, partner]")
    @Query("select c from Coupon c")
    List<Coupon> findAll();

    @Modifying
    @Transactional
    @Query("update Coupon c set c = :coupon where c.admitadId = :id")
    void update(Coupon coupon, Long id);

    @EntityGraph(value = "Coupon[regions, partner]")
    @Query("select c from Coupon c where c.partner.id = :partnerId")
    List<Coupon> findCouponByPartnerId(Long partnerId);

    @Modifying
    @Transactional
    @Query("delete from Coupon c where c.dateEnd < :dateTime")
    void deleteOverdueCoupon(LocalDateTime dateTime);

}
