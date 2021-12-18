package com.actionservice.client;

import com.actionservice.model.dto.Coupons;
import com.actionservice.model.dto.Partners;
import com.actionservice.model.dto.Regions;
import com.actionservice.model.dto.Websites;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "admitadClient", url = "https://api.admitad.com")
public interface AdmitadContentClient {

    @GetMapping(value = "/advcampaigns/?website={websiteId}&limit=${limit}")
    Partners partnerForSite(@PathVariable Long websiteId);

    @GetMapping(value = "/coupons/website/{websiteId}/?campaign={campaignId}&limit=${limit}")
    Coupons couponsForSite(@PathVariable Long websiteId, @PathVariable Long campaignId);

    @GetMapping(value = "/websites/regions/?limit=${limit}")
    Regions regions();

    @GetMapping(value = "/websites/v2/")
    Websites websites();
}