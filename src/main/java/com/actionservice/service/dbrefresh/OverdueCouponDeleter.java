package com.actionservice.service.dbrefresh;

import com.actionservice.service.coupons.CouponsDeleter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
@RequiredArgsConstructor
public class OverdueCouponDeleter {

    private static final int POOL_SIZE = 1;
    private static final String PREFIX_SCHEDULER = "OverdueCouponDeleter scheduler";
    private static final int AWAIT_TERMINATION_SEC = 180;
    private static final String COUPON_CRON = "0 0 0 * * *";
//    Only Test cron
//    private static final String COUPON_CRON = "*/10 * * * * *";

    private ThreadPoolTaskScheduler scheduler;
    private final CouponsDeleter deleter;

    @PostConstruct
    public void schedulerInit() {
        log.info("OverdueCouponDeleter schedulerInit");
        scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(POOL_SIZE);
        scheduler.setThreadNamePrefix(PREFIX_SCHEDULER);
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        scheduler.setAwaitTerminationSeconds(AWAIT_TERMINATION_SEC);
        scheduler.initialize();
        oldCouponDelete();
    }

    private void oldCouponDelete() {
        log.info("OverdueCouponDeleter coupon deleter launched");
        var couponCron = new CronTrigger(COUPON_CRON);
        scheduler.schedule(deleter::delete, couponCron);
    }

}
