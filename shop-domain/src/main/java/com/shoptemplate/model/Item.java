package com.shoptemplate.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item", schema = "shop")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, unique = true, nullable = false)
    private Long id;
    @Column
    private String name;
    @Column
    private double price;

//    if "Find all orders containing this item" is required then this can be uncommented
//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "orderItems")
//    private List<Order> itemOrders;
}