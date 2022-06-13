package com.ivanvelev.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "item")
public class Item {
    @Id
    @SequenceGenerator(name="itemtable_id_seq",
            sequenceName="itemtable_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "itemtable_id_seq")
    @Column(updatable = false, unique = true, nullable = false)
    private Long id;
    @Column
    private String name;
    @Column
    private double price;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "orderItems")
    private List<Order> itemOrders;

    public Item() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Order> getItemOrders() {
        return new ArrayList<>(itemOrders);
    }

    public void setItemOrders(List<Order> itemOrders) {
        this.itemOrders = itemOrders;
    }
}
