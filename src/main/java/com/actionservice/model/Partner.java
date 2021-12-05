package com.actionservice.model;

import com.actionservice.model.dto.Coupons;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

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
    private String name;

    @Column
    @JsonProperty(value = "image")
    private String imageUrl;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "partner", cascade = CascadeType.ALL, orphanRemoval = true)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Coupon> coupons;

    @Column
    private LocalDateTime lastUpdate;

    @JsonProperty(value = "categories")
    @OneToMany(mappedBy = "partner", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Category> categories;

    @Column
    private String description;

    @Column
    private Boolean exclusive;

}
