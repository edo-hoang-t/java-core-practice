package com.edocode.oop.exam.menu.impl;

import com.edocode.oop.exam.Main;
import com.edocode.oop.exam.configs.ApplicationContext;
import com.edocode.oop.exam.menu.Menu;

import java.util.Scanner;

public class MainMenu implements Menu {

    public static final String MENU_COMMAND = "menu"; // like a 'return main menu' button

    private static final String MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER =
            "Please, enter number in console to proceed." + System.lineSeparator()
            + "1. Sign Up" + System.lineSeparator()
            + "2. Sign In" + System.lineSeparator()
            + "3. Product Catalog" + System.lineSeparator()
            + "4. My Orders" + System.lineSeparator()
            + "5. Settings" + System.lineSeparator()
            + "6. Customer List";

    private static final String MAIN_MENU_TEXT_FOR_LOGGED_IN_USER =
            "Please, enter number in console to proceed." + System.lineSeparator()
            + "1. Sign Up" + System.lineSeparator()
            + "2. Sign Out" + System.lineSeparator()
            + "3. Product Catalog" + System.lineSeparator()
            + "4. My Orders" + System.lineSeparator()
            + "5. Settings" + System.lineSeparator()
            + "6. Customer List";

    private ApplicationContext context;

    {
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        if (context.getMainMenu() == null) {
            context.setMainMenu(this);
        }

        Menu nextMenu = null;

        loop: while (true) {
            printMenuHeader();
            System.out.print("User input: ");

            Scanner sc = new Scanner(System.in);
            String input = sc.next();

            if (input.equalsIgnoreCase(Main.EXIT_COMMAND)) break;
            int commandNumber;
            try {
                commandNumber = Integer.parseInt(input);
            } catch(NumberFormatException ex) {
                System.out.println("Only 1, 2, 3, 4, 5 and 6 is allowed. Try one more time");
                continue;
            }
            switch (commandNumber) {
                case 1:
                    nextMenu = new SignUpMenu();
                    break loop;
                case 2:
                    if (context.getLoggedInUser() == null) {
                        nextMenu = new SignInMenu();
                    } else {
                        nextMenu = new SignOutMenu();
                    }
                    break loop;
                case 3:
                    nextMenu = new ProductCatalogMenu();
                    break loop;
                case 4:
                    nextMenu = new MyOrdersMenu();
                    break loop;
                case 5:
                    nextMenu = new SettingsMenu();
                    break loop;
                case 6:
                    nextMenu = new CustomerListMenu();
                    break loop;
                default:
                    System.out.println("Only 1, 2, 3, 4, 5 and 6 is allowed. Try one more time");
                    continue;
            }
        }

        if (nextMenu == null) return;
        nextMenu.start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** MAIN MENU *****");
        if (context.getLoggedInUser() == null) {
            System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER);
        } else {
            System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_IN_USER);
        }
    }
}
