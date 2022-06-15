package com.edocode.oop.exam.configs;

import com.edocode.oop.exam.entities.Cart;
import com.edocode.oop.exam.entities.User;
import com.edocode.oop.exam.entities.impl.DefaultCart;
import com.edocode.oop.exam.menu.Menu;

public class ApplicationContext {

    private static ApplicationContext instance;

    private User loggedInUser;
    private Menu mainMenu;
    private Cart sessionCart;

    private ApplicationContext() { // prevent creation of instance
    }

    public User getLoggedInUser() {
        return this.loggedInUser;
    }

    public void setLoggedInUser(User user) {
        if (this.sessionCart != null) {
            this.sessionCart.clear(); // we have to clear session cart when new user is logged in
        }
        this.loggedInUser = user;
    }

    public Menu getMainMenu() {
        return this.mainMenu;
    }

    public void setMainMenu(Menu menu) {
        this.mainMenu = menu;
    }

    public static ApplicationContext getInstance() {
        if (instance == null) {
            instance = new ApplicationContext();
        }
        return instance;
    }

    public Cart getSessionCart() {
        if (this.sessionCart == null) {
            this.sessionCart = new DefaultCart();
        }
        return this.sessionCart;
    }

}
