package com.shoptemplate.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "country", schema = "shop")
public class Country {
    @Id
    @SequenceGenerator(name = "countrytable_id_seq",
            sequenceName = "countrytable_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "countrytable_id_seq")
    @Column(updatable = false, unique = true, nullable = false)
    private Long id;
    @Column
    private String country;

}
