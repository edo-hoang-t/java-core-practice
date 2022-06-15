package com.edocode.oop.exam.entities.impl;

import com.edocode.oop.exam.entities.User;

public class DefaultUser implements User {

    private static int userCounter = 0;

    private int id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    {
        id = ++userCounter;
    }

    public DefaultUser() {}

    public DefaultUser(String firstName, String lastName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    @Override
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    @Override
    public String toString() {
        return "First Name: " + this.getFirstName() + "\t\t" +
                "Last Name: " + this.getLastName() + "\t\t" +
                "Email: " + this.getEmail();
    }

    void clearState() {
        userCounter = 0;
    }
}
