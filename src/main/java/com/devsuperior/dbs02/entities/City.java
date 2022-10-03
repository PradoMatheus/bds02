package com.devsuperior.dbs02.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "city")
    private List<Event> events = new ArrayList<>();

    public City() {
    }

    public City(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
