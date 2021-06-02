package com.actionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableFeignClients
@EnableCaching
@PropertySource(value = "classpath:properties/admitad.yaml")
public class ActionServiceAdmitadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActionServiceAdmitadApplication.class, args);
    }

}
