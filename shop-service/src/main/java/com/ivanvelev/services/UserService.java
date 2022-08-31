package com.ivanvelev.services;

import com.ivanvelev.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(int id);

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(User user);
}
