package com.actionservice.service.dbrefresh;

import com.actionservice.client.AdmitadContentClient;
import com.actionservice.model.Action;
import com.actionservice.model.Partner;
import com.actionservice.repository.action.ActionDAOImpl;
import com.actionservice.repository.partner.PartnerDAOImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class DataBaseActionRefresh {

    private final PartnerDAOImpl partnerRepository;
    private final AdmitadContentClient admitadContentClient;
    private final ActionDAOImpl actionRepository;

    protected void dataBaseRefresh() {
        Map<Partner, List<Action>> actionsMap = partnerRepository.findAll()
                .stream()
                .collect(Collectors.toMap(partner -> partner, actionsList ->
                        admitadContentClient.actionsFromSite(actionsList.getId()).getActions()
                ));
        Map<Partner, List<Action>> partnerListMap = setPartnerAndDate(actionsMap);
        actionFromPartnerSave(partnerListMap);
        log.info("DataBaseActionRefresh DataBaseActionRefresh");
    }

    private Map<Partner, List<Action>> setPartnerAndDate(Map<Partner, List<Action>> actionsMap) {
        actionsMap
                .forEach((partner, actionList) -> actionList
                        .forEach(action -> {
                            action.setPartner(partner);
                            if (action.getDateEnd() == null) {
                                action.setDateEnd(LocalDateTime.of(4000, 10, 20, 10, 10));
                            }
                            action.setLastUpdate(LocalDateTime.now());
                        }));
        return actionsMap;
    }

    private void actionFromPartnerSave(Map<Partner, List<Action>> actionsMap) {
        log.info("DataBaseActionRefresh actionFromPartnerSave save -{}", actionsMap);
        actionsMap.entrySet()
                .forEach(entry -> actionRepository.saveAll(entry.getValue()));
    }
}