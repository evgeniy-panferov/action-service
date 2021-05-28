package com.actionservice.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginAdmitad {

     @JsonProperty("access_token")
     private String accessToken;
     @JsonProperty("expires_in")
     private String expiresIn;
     @JsonProperty("refresh_token")
     private String refreshToken;
}
