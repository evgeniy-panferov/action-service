package com.actionservice.repository.partner;

import com.actionservice.model.Partner;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrudPartnerRepository extends JpaRepository<Partner, Long> {

    @EntityGraph("Partner[coupons]")
    List<Partner> findAll();
}
