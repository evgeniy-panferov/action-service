package com.actionservice.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Action {

    // @Column
    private String status;

    //  @ManyToOne(fetch = FetchType.LAZY)
    //  @JoinColumn(name = "campaign_id")
    private Campaign campaign;

    //  @Column
    private String description;

    //  @ElementCollection(fetch = FetchType.EAGER)
    //  @CollectionTable(
    //          name = "Region",
    //          joinColumns = @JoinColumn(name = "coupon_id")
    //  )
    //  @Column(name = "region")
    //  @BatchSize(size = 50)
    private List<String> regions;

    //   @Column
    private String discount;

    //  @Column
    private String species;

    //   @Column
    private String promocode;

    //   @Column(name = "frameset_link")
    @JsonProperty(value = "frameset_link")
    private String framesetLink;

    // @Column(name = "goto_link")
    @JsonProperty(value = "goto_link")
    private String gotoLink;

    // @Column(name = "short_name")
    @JsonProperty(value = "short_name")
    private String shortName;

    // @Column(name = "date_start")
    @JsonProperty(value = "date_start")
    // @JsonDeserialize(using = JsonDateSerializer.class)
    private LocalDateTime dateStart;

    // @Column(name = "date_end")
    @JsonProperty(value = "date_end")
    // @JsonDeserialize(using = JsonDateSerializer.class)
    private LocalDateTime dateEnd;

    //  @Column(name = "image_url")
    @JsonProperty(value = "image")
    private String imageUrl;

}
