package com.actionservice.controller;

import com.actionservice.client.AdmitadContentClient;
import com.actionservice.model.Action;
import com.actionservice.model.Partner;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ControllerAdmitad {

    private final AdmitadContentClient admitadContentClient;

    @GetMapping
    public List<Partner> programsFromSite() {
        return admitadContentClient.partnerFromSite().getPartners();
    }

    @GetMapping("action/{campaignId}")
    public List<Action> actionFromProgram(@PathVariable Long campaignId) {
        return admitadContentClient.actionsFromSite(campaignId).getActions();
    }

}
