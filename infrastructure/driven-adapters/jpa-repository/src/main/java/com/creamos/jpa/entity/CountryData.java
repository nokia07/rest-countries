package com.creamos.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "countries")
public class CountryData {
    @Id
    private Integer id;
    @Column
    private String name;
    @Column
    private String capital;
    @Column
    private String currency;
    @Column
    private Double population;
}
