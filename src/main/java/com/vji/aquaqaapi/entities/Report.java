package com.vji.aquaqaapi.entities;


import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;


@Entity
@Table(name = "reports")
@Getter @Setter
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float externalTemp;

    private Float externalHum;

    private Float internalTemp;

    private Float phValue;

    private Float tdsValue;

    private Float tsValue;

    private Float tensionValue;

    private Boolean level;

    @ManyToOne
    private User user;
}
