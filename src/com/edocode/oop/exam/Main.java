package com.edocode.oop.exam;

import com.edocode.oop.exam.menu.Menu;
import com.edocode.oop.exam.menu.impl.MainMenu;

public class Main {
    public static final String EXIT_COMMAND = "exit";

    public static void main(String[] args) {
        Menu mainMenu = new MainMenu();
        mainMenu.start();
    }
}
