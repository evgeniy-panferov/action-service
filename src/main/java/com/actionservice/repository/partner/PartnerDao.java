package com.actionservice.repository.partner;

import com.actionservice.model.Partner;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartnerDao {

    List<Partner> findAll();

    Partner save(Partner partner);

    List<Partner> saveAll(List<Partner> partners);

}
