package com.actionservice.service;

import com.actionservice.client.AdmitadContentClient;
import com.actionservice.model.Website;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class WebmasterWebsiteService {

    private final AdmitadContentClient admitadContentClient;

    @Cacheable("websiteIds")
    public Long getWebsiteId(String areaName) {
        log.info("Find id for area - {}", areaName);
        return admitadContentClient.websites().getWebsites()
                .stream()
                .filter(site -> site.getName().equals(areaName))
                .map(Website::getAdmitadId)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
