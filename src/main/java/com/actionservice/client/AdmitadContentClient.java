package com.actionservice.client;

import com.actionservice.client.model.dto.Actions;
import com.actionservice.client.model.dto.Programs;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "admitadClient", url = "https://api.admitad.com")
public interface AdmitadContentClient {

    @GetMapping(value = "/advcampaigns/?website=${websiteId}&limit=${limit}")
    Programs programsFromSite();

    @GetMapping(value = "/coupons/website/${websiteId}/?campaign={campaignId}&${limit}")
    Actions actionsFromSite(@PathVariable String campaignId);

}