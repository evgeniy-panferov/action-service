package com.actionservice.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NamedEntityGraph(name = "Coupon[regions]", attributeNodes = {
        @NamedAttributeNode("regions")
})
public class Coupon {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty(value = "id")
    @Column(name = "admitad_id")
    private Long admitadId;

    @Column
    private String name;

    @Column
    private String status;

    @JsonProperty(value = "campaign")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonBackReference
    private Partner partner;

    @Column
    private String description;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "region",
            joinColumns = @JoinColumn(name = "coupon_id")
    )
    @Column(name = "name")
    private List<String> regions;

    @Column
    private String discount;

    @Column
    private String species;

    @Column
    private String promocode;

    @Column
    @JsonProperty(value = "frameset_link")
    private String framesetLink;

    @Column
    @JsonProperty(value = "goto_link")
    private String gotoLink;

    @Column
    @JsonProperty(value = "short_name")
    private String shortName;

    @Column
    @JsonProperty(value = "date_start")
    private LocalDateTime dateStart;

    @Column
    @JsonProperty(value = "date_end")
    private LocalDateTime dateEnd;

    @Column
    @JsonProperty(value = "image")
    private String imageUrl;

    @Column
    private LocalDateTime lastUpdate;

}
