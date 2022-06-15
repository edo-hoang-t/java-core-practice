package com.edocode.oop.exam.menu.impl;

import com.edocode.oop.exam.configs.ApplicationContext;
import com.edocode.oop.exam.entities.User;
import com.edocode.oop.exam.menu.Menu;
import com.edocode.oop.exam.services.UserManagementService;
import com.edocode.oop.exam.services.impl.DefaultUserManagementService;

import java.util.Scanner;

public class SignInMenu implements Menu {

    private ApplicationContext context;
    private UserManagementService userManagementService;

    {
        context = ApplicationContext.getInstance();
        userManagementService = DefaultUserManagementService.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        Scanner sc = new Scanner(System.in);

        System.out.println("Please, enter your email: ");
        String email = sc.nextLine();
        System.out.println("Please, enter your password: ");
        String password = sc.next();

        User user = userManagementService.getUserByEmail(email);
        if (user == null) {
            System.out.println("Unfortunately, such login and password doesn’t exist!");
        } else if (user.getPassword() != password) {
            System.out.println("Unfortunately, such login and password doesn’t exist!");
        } else {
            context.setLoggedInUser(user);
            System.out.println("Glad to see you back, "  + user.getFirstName() + " " + user.getLastName());
        }

        context.getMainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** Sign In *****");
    }
}
