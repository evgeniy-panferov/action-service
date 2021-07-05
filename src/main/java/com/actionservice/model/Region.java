package com.actionservice.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "region")
@Data
public class Region {

    @Id
    @Column
    private String name;
}
