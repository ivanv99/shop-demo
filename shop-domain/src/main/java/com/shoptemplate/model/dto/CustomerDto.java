package com.shoptemplate.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerDto {

    private String firstName;

    private String lastName;

    private String email;

    public CustomerDto(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public CustomerDto() {
    }

}
