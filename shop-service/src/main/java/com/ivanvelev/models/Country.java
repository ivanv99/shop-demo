package com.ivanvelev.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "countries")
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

    public Country() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country1 = (Country) o;
        return Objects.equals(getId(), country1.getId()) && Objects.equals(getCountry(), country1.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCountry());
    }
}
