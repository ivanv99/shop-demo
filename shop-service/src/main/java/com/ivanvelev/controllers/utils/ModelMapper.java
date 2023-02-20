package com.ivanvelev.controllers.utils;

import com.ivanvelev.models.User;
import com.ivanvelev.models.UserCredentials;
import com.ivanvelev.models.dto.UserCredentialsDto;
import com.ivanvelev.models.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper {

    public User convertToUserFromDto(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUserCredentials(convertToUserCredentialsFromDto(userDto.getUserCredentialsDto()));
        return user;
    }

    public UserCredentials convertToUserCredentialsFromDto(UserCredentialsDto userCredentialsDto) {
        UserCredentials userCredentials = new UserCredentials();
        userCredentials.setUsername(userCredentialsDto.getUsername());
        userCredentials.setPassword(userCredentialsDto.getPassword());
        userCredentials.setEmail(userCredentialsDto.getEmail());
        return userCredentials;
    }

}
