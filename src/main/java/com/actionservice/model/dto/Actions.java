package com.actionservice.model.dto;

import com.actionservice.model.Action;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Actions {

    @JsonProperty(value = "results")
    private List<Action> actions;

}
