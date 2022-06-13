package com.ivanvelev.repositories;

import com.ivanvelev.models.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();

    User getUserById(int id);

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(User user);
}
