package com.bmv.kiemtramodule4.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "mycity")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "national")
    private String national;

    @Column(name = "area")
    private Long area;

    @Column(name = "popular")
    private Long popular;

    @Column(name = "GDP")
    private Long GDP;

    @Column(name = "description")
    private String description;

    public City(){}

    public City(@NotEmpty String name, String national, Long area, Long popular, Long GDP, String description) {
        this.name = name;
        this.national = national;
        this.area = area;
        this.popular = popular;
        this.GDP = GDP;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Long getPopular() {
        return popular;
    }

    public void setPopular(Long popular) {
        this.popular = popular;
    }

    public Long getGDP() {
        return GDP;
    }

    public void setGDP(Long GDP) {
        this.GDP = GDP;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
