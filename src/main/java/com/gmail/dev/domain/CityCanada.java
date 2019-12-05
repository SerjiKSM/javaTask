package com.gmail.dev.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(schema = "dev", name = "cities_canada")
public class CityCanada {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title", columnDefinition = "VARCHAR")
    private String title;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="province_id", updatable = false, insertable = false)
    private ProvinceCanada provinceCanada;
}
