package com.actionservice.controller;

import com.actionservice.client.AdmitadAuthorization;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class AuthorizationController {

    private final AdmitadAuthorization admitadAuthorization;

    @GetMapping
    public String testController() {
        return admitadAuthorization.getToken();
    }
}
