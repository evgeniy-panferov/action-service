package com.actionservice.service.dbrefresh;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
@AllArgsConstructor
public class DbRefreshFacade {

    private final DataBasePartnerRefresh dataBasePartnerRefresh;
    private final DataBaseActionRefresh dataBaseActionRefresh;

    @PostConstruct
    public void dbInit() {
        log.info("DbRefreshFacade dbInit");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(dataBasePartnerRefresh::dataBaseRefresh);
        executorService.execute(dataBaseActionRefresh::dataBaseRefresh);
        dbRefresh();
        log.info("DbRefreshFacade run run run");
    }

    private void dbRefresh() {
        log.info("DbRefreshFacade dbRefresh");
        ScheduledExecutorService executor1 = Executors.newScheduledThreadPool(1);
        ScheduledExecutorService executor2 = Executors.newScheduledThreadPool(1);
        executor1.scheduleAtFixedRate(dataBasePartnerRefresh::dataBaseRefresh, 24, 24, TimeUnit.HOURS);
        executor2.scheduleAtFixedRate(dataBaseActionRefresh::dataBaseRefresh, 32400, 32400, TimeUnit.SECONDS);
    }
}