package com.actionservice.repository.coupon;

import com.actionservice.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CrudCouponRepository extends JpaRepository<Coupon, Long> {

    @Modifying
    @Transactional
    @Query("update Coupon c set c = :coupon where c.admitadId = :id")
    void update(Coupon coupon, Long id);

}
