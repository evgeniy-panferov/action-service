package com.actionservice.service.dbrefresh;

import com.actionservice.service.coupons.CouponService;
import com.actionservice.service.partners.PartnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
@RequiredArgsConstructor
public class DbRefreshFacade {

    private static final int POOL_SIZE = 1;
    private static final String PREFIX_SCHEDULER = "DbRefreshFacade";
    private static final int AWAIT_TERMINATION_SEC = 180;
    private static final String PARTNER_CRON = "0 0 1 * * *";
    private static final String COUPON_CRON = "0 0 */4 * * *";
//    Only Test cron
//    private static final String PARTNER_CRON = "10 * * * * *";
//    private static final String COUPON_CRON = "20 * * * * *";

    private final PartnerService partnerService;
    private final CouponService couponService;
    private ThreadPoolTaskScheduler scheduler;

    @PostConstruct
    public void dbInit() {
        log.info("DbRefreshFacade dbInit");
        scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(POOL_SIZE);
        scheduler.setThreadNamePrefix(PREFIX_SCHEDULER);
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        scheduler.setAwaitTerminationSeconds(AWAIT_TERMINATION_SEC);
        scheduler.initialize();
        dbRefresh();
        log.info("DbRefreshFacade run run run");
    }

    private void dbRefresh() {
        log.info("DbRefreshFacade dbRefresh");
        var partnerCron = new CronTrigger(PARTNER_CRON);
        var couponCron = new CronTrigger(COUPON_CRON);
        scheduler.schedule(partnerService::partnerUpdate, partnerCron);
        scheduler.schedule(couponService::couponUpdate, couponCron);
    }
}