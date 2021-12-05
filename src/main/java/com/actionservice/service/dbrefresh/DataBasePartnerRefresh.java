package com.actionservice.service.dbrefresh;


import com.actionservice.client.AdmitadContentClient;
import com.actionservice.model.Partner;
import com.actionservice.repository.partner.PartnerDAOImpl;
import com.actionservice.service.WebmasterWebsiteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class DataBasePartnerRefresh {

    private final WebmasterWebsiteService webmasterWebsiteService;
    private final AdmitadContentClient admitadContentClient;
    private final PartnerDAOImpl partnerRepository;

    public void dataBaseRefresh() {
        log.info("DataBasePartnerRefresh dataBaseRefresh");
        List<Partner> partners = admitadContentClient.partnerForSite(
                webmasterWebsiteService.getWebsiteId("YouPromocodeBot")).getPartners();

        partnerRepository.saveAll(partners);
    }


}
