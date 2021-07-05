package com.actionservice.repository.partner;

import com.actionservice.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudPartnerRepository extends JpaRepository<Partner, Long> {

}
