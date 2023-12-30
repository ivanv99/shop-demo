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
    @SequenceGenerator(name = "addresstable_id_seq",
            sequenceName = "addresstable_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addresstable_id_seq")
    @Column(updatable = false, unique = true, nullable = false)
    private Long id;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "country_id")
    private Country country;
    @Column(name = "address_details")
    private String addressDetails;

}
