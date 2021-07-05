package com.actionservice.service.dbrefresh;


import com.actionservice.client.AdmitadContentClient;
import com.actionservice.repository.partner.PartnerDAOImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class DataBasePartnerRefresh {

    private final AdmitadContentClient admitadContentClient;
    private final PartnerDAOImpl partnerRepository;

    public void dataBaseRefresh() {
        log.info("DataBasePartnerRefresh dataBaseRefresh");
        partnerRepository.saveAll(admitadContentClient.partnerFromSite().getPartners());
    }


}
