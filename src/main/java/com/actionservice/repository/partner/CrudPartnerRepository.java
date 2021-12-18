package com.actionservice.repository.partner;

import com.actionservice.model.Partner;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CrudPartnerRepository extends JpaRepository<Partner, Long> {

    @EntityGraph("Partner[coupons]")
    List<Partner> findAll();

    @Modifying
    @Query("update Partner p set p = :partner where p.admitadId = :id")
    @Transactional
    void update(Partner partner, Long id);
}
