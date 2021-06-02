package com.actionservice.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager("tokenCache");
        caffeineCacheManager.setCaffeine(Caffeine
                .newBuilder()
                .maximumSize(5)
                .expireAfterWrite(50000, TimeUnit.SECONDS));
        return caffeineCacheManager;
    }


}
