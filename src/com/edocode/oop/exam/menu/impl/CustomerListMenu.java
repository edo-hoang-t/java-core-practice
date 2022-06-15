package com.edocode.oop.exam.menu.impl;

import com.edocode.oop.exam.configs.ApplicationContext;
import com.edocode.oop.exam.entities.User;
import com.edocode.oop.exam.menu.Menu;
import com.edocode.oop.exam.services.UserManagementService;
import com.edocode.oop.exam.services.impl.DefaultUserManagementService;

public class CustomerListMenu implements Menu {

    private ApplicationContext context;
    private UserManagementService userManagementService;

    {
        userManagementService = DefaultUserManagementService.getInstance();
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();

        User[] users = userManagementService.getUsers();

        if (users.length == 0) {
            System.out.println("Unfortunately, there are no customers.");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
        context.getMainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** USERS *****");
    }

}
