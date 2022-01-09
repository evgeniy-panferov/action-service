package com.actionservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.engine.backend.types.TermVector;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Indexed
@Getter
@Setter
@Entity
@NamedEntityGraph(name = "Partner[coupons]", attributeNodes = {
        @NamedAttributeNode("coupons"),
        @NamedAttributeNode("categories")
})
public class Partner {

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
    @JsonProperty(value = "image")
    private String imageUrl;

    @OneToMany(mappedBy = "partner", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JsonManagedReference
    private List<Coupon> coupons;

    @Column
    private LocalDateTime lastUpdate;

    @JsonProperty(value = "categories")
    @OneToMany(mappedBy = "partner", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Category> categories;

    @Column
    @FullTextField(termVector = TermVector.YES)
    private String description;

    @Column
    private Boolean exclusive;

}
