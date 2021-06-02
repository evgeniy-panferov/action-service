package com.actionservice.client;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class FeignInterceptor implements RequestInterceptor {

    private final AdmitadAuthorizationClient admitadAuthorizationClient;

    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", "Bearer " + admitadAuthorizationClient.getToken());
        log.info("Feign interceptor {}", template.toString());
    }
}
