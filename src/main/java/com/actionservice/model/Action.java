package com.actionservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Action {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String status;

    @JsonProperty(value = "campaign")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "partner_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Partner partner;

    @Column
    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "region",
            joinColumns = @JoinColumn(name = "action_id")
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

    @Override
    public String toString() {
        return "Action{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", discount='" + discount + '\'' +
                ", species='" + species + '\'' +
                ", promocode='" + promocode + '\'' +
                ", framesetLink='" + framesetLink + '\'' +
                ", gotoLink='" + gotoLink + '\'' +
                ", shortName='" + shortName + '\'' +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", imageUrl='" + imageUrl + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
