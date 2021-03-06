package com.actionservice.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.search.engine.backend.types.TermVector;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Indexed
@Entity
@Getter
@Setter
@NamedEntityGraph(name = "Coupon[regions, partner]", attributeNodes = {
        @NamedAttributeNode("regions"),
        @NamedAttributeNode("partner")
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
    @FullTextField(termVector = TermVector.YES)
    private String name;

    @Column
    private String status;

    @JsonProperty(value = "campaign")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonBackReference
    private Partner partner;

    @Column
    @FullTextField(termVector = TermVector.YES)
    private String description;

    @BatchSize(size = 100)
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
    @FullTextField(termVector = TermVector.YES)
    private String shortName;

    @Column
    @JsonProperty(value = "date_start")
    private LocalDateTime dateStart;

    @Column
    @JsonProperty(value = "date_end")
    @GenericField
    private LocalDateTime dateEnd;

    @Column
    @JsonProperty(value = "image")
    private String imageUrl;

    @Column
    private LocalDateTime lastUpdate;

}
