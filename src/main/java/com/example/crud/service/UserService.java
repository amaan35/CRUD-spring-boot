package com.example.crud.service;

import com.example.crud.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> fetchAllUsers();
    User findUserByID(Long id);

    User updateUserByID(Long id, User updatedUser);
    String deleteUser(Long id);
}









