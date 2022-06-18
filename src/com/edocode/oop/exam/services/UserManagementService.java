package com.edocode.oop.exam.services;

import com.edocode.oop.exam.entities.User;

import java.util.List;

public interface UserManagementService {

    String registerUser(User user);

    List<User> getUsers();

    User getUserByEmail(String userEmail);
}
