package com.edocode.oop.exam.services;

import com.edocode.oop.exam.entities.User;

public interface UserManagementService {

    String registerUser(User user);

    User[] getUsers();

    User getUserByEmail(String userEmail);
}
