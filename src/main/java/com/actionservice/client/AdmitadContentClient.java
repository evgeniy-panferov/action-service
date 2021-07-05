package com.actionservice.client;

import com.actionservice.model.dto.Actions;
import com.actionservice.model.dto.Programs;
import com.actionservice.model.dto.Regions;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "admitadClient", url = "https://api.admitad.com")
public interface AdmitadContentClient {

    @GetMapping(value = "/advcampaigns/?website=${websiteId}&limit=${limit}")
    Programs partnerFromSite();

    @GetMapping(value = "/coupons/website/${websiteId}/?campaign={campaignId}&limit=${limit}")
    Actions actionsFromSite(@PathVariable Long campaignId);

    @GetMapping(value = "/websites/regions/?limit=${limit}")
    Regions regions();
}