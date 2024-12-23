package com.shoptemplate.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address", schema = "shop")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, unique = true, nullable = false)
    private Long id;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "street", nullable = false, length = 100)
    private String street;

    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @Column(name = "state", nullable = false, length = 50)
    private String state;

    @Column(name = "zip_code", nullable = false, length = 10)
    private String zipCode;
}