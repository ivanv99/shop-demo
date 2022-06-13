package com.ivanvelev.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "orders")
public class Order {
    @Id
    @SequenceGenerator(name="orderstable_id_seq",
            sequenceName="orderstable_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "orderstable_id_seq")
    @Column(updatable = false, unique = true, nullable = false)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Orders_items",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> orderItems;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_and_time")
    private Timestamp timestamp;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Item> getOrderItems() {
        return new ArrayList<>(orderItems);
    }

    public void setOrderItems(List<Item> orderItems) {
        this.orderItems = orderItems;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
