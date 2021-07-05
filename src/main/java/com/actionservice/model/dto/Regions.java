package com.actionservice.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Regions {

    @JsonProperty(value = "results")
    private List<String> regions;
}
