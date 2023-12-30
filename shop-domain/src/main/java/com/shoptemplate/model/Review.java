package com.shoptemplate.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "review", schema = "shop")
public class Review {
    @Id
    @SequenceGenerator(name = "reviewtable_id_seq",
            sequenceName = "reviewtable_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reviewtable_id_seq")
    @Column(updatable = false, unique = true, nullable = false)
    private Long id;
    @Column
    private String review;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @Column
    private String name;

}
