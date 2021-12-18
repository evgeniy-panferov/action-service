package com.actionservice.service.partners;


import com.actionservice.client.AdmitadContentClient;
import com.actionservice.model.Partner;
import com.actionservice.repository.partner.PartnerDAOImpl;
import com.actionservice.service.WebmasterWebsiteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class PartnerService {

    private final WebmasterWebsiteService webmasterWebsiteService;
    private final AdmitadContentClient admitadContentClient;
    private final PartnerDAOImpl partnerRepository;

    @Transactional
    public void partnerUpdate() {

        List<Partner> partnersAdmitad = admitadContentClient.partnerForSite(
                webmasterWebsiteService.getWebsiteId("YouPromocodeBot")).getPartners();

        Map<Long, Partner> partnerByIdAdm = partnersAdmitad.stream()
                .collect(Collectors.toMap(Partner::getAdmitadId, Function.identity()));

        List<Partner> partnersDb = partnerRepository.findAll();

        Map<Long, Partner> partnerByIdBd = partnersDb.stream().
                collect(Collectors.toMap(Partner::getAdmitadId, Function.identity()));

        Set<Long> changedPartnerId = PartnerChangeFinder.find(partnersAdmitad, partnersDb);

        changedPartnerId.forEach(id -> {
            Partner partnerDb = partnerByIdBd.get(id);
            Partner partnerAdm = partnerByIdAdm.get(id);
//            partnerAdm.addCategories(partnerAdm.getCategories());
            if (partnerDb != null) {
                log.info("Update partner by id - {}, partner - {}", id, partnerDb);
                partnerAdm.setId(partnerDb.getId());
                partnerRepository.update(partnerAdm, id);
            } else {
                log.info("Save new partner by id - {}, partner - {}", id, partnerDb);
                partnerRepository.save(partnerAdm);
            }
        });
    }


}
