package com.ivanvelev.models.dto;

public class UserDto {

    private String firstName;

    private String lastName;

    private UserCredentialsDto userCredentialsDto;

    public UserDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserCredentialsDto getUserCredentialsDto() {
        return userCredentialsDto;
    }

    public void setUserCredentialsDto(UserCredentialsDto userCredentialsDto) {
        this.userCredentialsDto = userCredentialsDto;
    }
}
