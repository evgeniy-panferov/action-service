package com.actionservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Partner {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    @JsonProperty(value = "image")
    private String imageUrl;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "partner", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Action> actions;

    @Column
    private LocalDateTime lastUpdate;


    @Override
    public String toString() {
        return "Partner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
