package com.actionservice.client;

import com.actionservice.client.model.LoginAdmitad;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Objects;

@Slf4j
@Component
@RequiredArgsConstructor
public class AdmitadAuthorizationClient {

    @Value("${client_id}")
    private String clientId;
    @Value("${client_secret}")
    private String clientSecret;
    @Value("${scope}")
    private String scope;
    @Value("${authorization_url}")
    private String authorizationUrl;

    private final RestTemplate restTemplate;

    @Cacheable("tokenCache")
    public String getToken() {
        log.info("AdmitadAuthorization getToken");

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "client_credentials");
        map.add("client_id", clientId);
        map.add("scope", scope);

        ResponseEntity<LoginAdmitad> response = restTemplate.exchange(authorizationUrl,
                HttpMethod.POST, new HttpEntity<>(map, getHttpHeaders()), LoginAdmitad.class);

        return Objects.requireNonNull(response.getBody()).getAccessToken();
    }

    private HttpHeaders getHttpHeaders() {
        log.info("AdmitadConnectionApi getHttpHeaders");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.setBasicAuth(clientId, clientSecret);
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return httpHeaders;
    }

}
