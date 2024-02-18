package org.example.service;

import org.example.entity.User;

import java.util.List;

public interface UserService {
    boolean addUsers(User user);
    boolean loginUser(User user);

    List<User> getAllUsers();
}
