package com.actionservice.model.dto;

import com.actionservice.config.WebsiteDeserializer;
import com.actionservice.model.Website;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.util.List;

@Data
@JsonDeserialize(using = WebsiteDeserializer.class)
public class Websites {

    @JsonProperty
    private List<Website> websites;
}
