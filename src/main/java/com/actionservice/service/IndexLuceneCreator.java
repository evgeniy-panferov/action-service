package com.actionservice.service;

import com.actionservice.model.Coupon;
import com.actionservice.model.Partner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.massindexing.MassIndexer;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@Slf4j
@RequiredArgsConstructor
public class IndexLuceneCreator {

    private final EntityManager entityManager;

    @EventListener(ContextRefreshedEvent.class)
    public void onApplicationEvent(ContextRefreshedEvent event) {
        event.getApplicationContext().getBean(IndexLuceneCreator.class).initIndex();
    }

    @Transactional
    public void initIndex() {
        log.info("Index creator begun work");
        SearchSession searchSession = Search.session(entityManager);
        MassIndexer couponIndexer = searchSession.massIndexer(Coupon.class);
        MassIndexer partnerIndexer = searchSession.massIndexer(Partner.class);
        ExecutorService couponThread = Executors.newSingleThreadExecutor();
        ExecutorService partnerThread = Executors.newSingleThreadExecutor();


        couponThread.execute(() -> {
            try {
                couponIndexer.startAndWait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.error("CouponThread - an error has occurred, cause - {}, message - {}", e.getCause(), e.getMessage());
            }
        });

        partnerThread.execute(() -> {
            try {
                partnerIndexer.startAndWait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.error("PartnerThread - an error has occurred, cause - {}, message - {}", e.getCause(), e.getMessage());
            }
        });
    }

}
