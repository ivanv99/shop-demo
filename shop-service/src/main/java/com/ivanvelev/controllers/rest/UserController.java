package com.ivanvelev.controllers.rest;

import com.ivanvelev.controllers.utils.ModelMapper;
import com.ivanvelev.models.User;
import com.ivanvelev.models.dto.UserDto;
import com.ivanvelev.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User create(@RequestBody UserDto userDto) {
        User user = modelMapper.convertToUserFromDto(userDto);
        userService.createUser(user);
        return user;
    }


}
