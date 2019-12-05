package com.gmail.dev.domain;

import com.gmail.dev.enums.City;
import com.gmail.dev.enums.Role;
import com.gmail.dev.enums.State;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(schema = "dev", name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name", columnDefinition = "VARCHAR")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "VARCHAR")
    private String lastName;

    @Column(name = "login", columnDefinition = "VARCHAR")
    private String login;

    @Column(name = "password", columnDefinition = "VARCHAR")
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @Enumerated(value = EnumType.STRING)
    private City city;

    @ManyToOne (optional=false)
    @JoinColumn (name="state_usa_id", updatable = false)
    private StateUSA stateUSA;

    @ManyToOne (optional=false)
    @JoinColumn (name="city_canada_id", updatable = false)
    private CityCanada cityCanada;
}
