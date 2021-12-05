package com.actionservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private String name;

    @JsonProperty(value = "id")
    private Long admitadId;

    private String language;

    @ManyToOne
    @JoinColumn(name = "partner_id")
    private Partner partner;

}
