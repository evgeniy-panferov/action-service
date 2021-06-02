package com.actionservice.controller;

import com.actionservice.client.AdmitadContentClient;
import com.actionservice.client.model.Action;
import com.actionservice.client.model.Campaign;
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
    public List<Campaign> programsFromSite() {
        return admitadContentClient.programsFromSite().getCampaigns();
    }

    @GetMapping("action/{campaignId}")
    public List<Action> actionFromProgram(@PathVariable String campaignId) {
        return admitadContentClient.actionsFromSite(campaignId).getActions();
    }

}
