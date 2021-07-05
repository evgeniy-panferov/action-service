package com.actionservice.repository.partner;

import com.actionservice.model.Partner;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Repository
@AllArgsConstructor
public class PartnerDAOImpl implements PartnerDao {

    private final CrudPartnerRepository crudPartnerRepository;

    @Override
    public List<Partner> findAll() {
        return crudPartnerRepository.findAll();
    }

    @Override
    public Partner save(Partner partner) {
        return crudPartnerRepository.save(partner);
    }

    @Override
    public List<Partner> saveAll(List<Partner> partners) {
        log.info("PartnerRepositoryImpl SaveAll - {}", partners);
        partners = partners
                .stream()
                .peek(partner -> partner.setLastUpdate(LocalDateTime.now()))
                .collect(Collectors.toList());

        return crudPartnerRepository.saveAll(partners);
    }
}
