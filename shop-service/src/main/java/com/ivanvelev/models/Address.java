package com.ivanvelev.models;


import javax.persistence.*;
@Entity(name = "address")
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

    public Address() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(String addressDetails) {
        this.addressDetails = addressDetails;
    }
}
