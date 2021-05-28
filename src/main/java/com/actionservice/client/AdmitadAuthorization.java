package com.actionservice.client;

import com.actionservice.client.model.LoginAdmitad;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
public class AdmitadAuthorization {

    @Value("${grant_type}")
    private String grantType;
    @Value("${client_id}")
    private String clientId;
    @Value("${client_secret}")
    private String clientSecret;
    @Value("${scope}")
    private String scope;

    private final RestTemplate restTemplate;

    private static final String AUTHORIZATION_URL = "https://api.admitad.com/token/";

    public String getToken() {
        log.info("AdmitadAuthorization getToken");

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "client_credentials");
        map.add("client_id", clientId);
        map.add("scope", scope);

        ResponseEntity<LoginAdmitad> response = restTemplate.exchange(AUTHORIZATION_URL,
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
