package com.shoptemplate.controller.rest;

import com.shoptemplate.controller.utils.ModelMapper;
import com.shoptemplate.model.User;
import com.shoptemplate.model.dto.UserDto;
import com.shoptemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {
        if (userService.getUserById(id).isPresent()) {
            return userService.getUserById(id).get();
        }
        return null;
    }

    @PostMapping
    public User create(@RequestBody UserDto userDto) {
        User user = modelMapper.convertToUserFromDto(userDto);
        userService.createUser(user);
        return user;
    }

    @DeleteMapping("/{id}")
    public User delete(@PathVariable int id) {
        if (userService.getUserById(id).isPresent()) {
            User user = userService.getUserById(id).get();
            userService.deleteUser(user);
            return user;
        }
        return null;
    }
}
