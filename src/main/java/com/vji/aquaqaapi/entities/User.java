package com.vji.aquaqaapi.entities;


import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter @Setter

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastname;

    private Integer phoneNumber;

    private String email;

    private String password;

    private String rol;

    @OneToMany(mappedBy = "user")
    private Set<Report> reports;
}
