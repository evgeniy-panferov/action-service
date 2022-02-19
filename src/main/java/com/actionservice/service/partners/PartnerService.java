package com.actionservice.service.partners;


import com.actionservice.client.AdmitadContentClient;
import com.actionservice.client.TelegramDiscountServiceClient;
import com.actionservice.model.Partner;
import com.actionservice.model.dto.telegram.PartnerDto;
import com.actionservice.repository.partner.PartnerDAOImpl;
import com.actionservice.service.WebmasterWebsiteService;
import com.actionservice.util.PartnerUtil;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
    private final TelegramDiscountServiceClient telegramDiscountServiceClient;

    @Transactional
    public void send() {
        log.info("Start partner DB update");
        update();

        List<List<PartnerDto>> partnerDtos = Lists.partition(PartnerUtil.toDtos(partnerRepository.findAll()), 5);
        partnerDtos.forEach(telegramDiscountServiceClient::sendPartner);
    }

    @Transactional
    public void update(){
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
            partnerAdm.setLastUpdate(LocalDateTime.now());
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
