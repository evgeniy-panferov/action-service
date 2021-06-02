package com.actionservice.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Campaign {

    // @Id
    // @Column(name = "id")
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @JsonProperty
    protected Integer id;

    // @Column(name = "name")
    private String name;

    // @Column(name = "image_url")
    @JsonProperty(value = "image")
    private String imageUrl;

    // @Column(name = "connection_status")
//    @JsonProperty(value = "connection_status")
//    private String connectionStatus;

    // @Column(name = "is_database_entity")
    private Boolean isDatabaseEntity = false;

    // @OneToMany(mappedBy = "campaign")
    // @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Action> coupons;

}
