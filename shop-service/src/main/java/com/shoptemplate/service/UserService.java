package com.shoptemplate.service;

import com.shoptemplate.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    Optional<User> getUserById(int id);

    void createUser(User customer);

    void updateUser(User customer);

    void deleteUser(User customer);
}
