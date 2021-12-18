package com.actionservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Website {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty(value = "id")
    @Column(name = "admitad_id")
    private Long admitadId;

    private String status;

    private String name;

}
