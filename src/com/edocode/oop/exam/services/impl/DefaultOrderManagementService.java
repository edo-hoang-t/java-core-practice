package com.edocode.oop.exam.services.impl;

import com.edocode.oop.exam.entities.Order;
import com.edocode.oop.exam.services.OrderManagementService;
import com.edocode.oop.exam.services.ProductManagementService;

import java.util.ArrayList;
import java.util.List;

public class DefaultOrderManagementService implements OrderManagementService {

    private List<Order> orders;

    {
        orders = new ArrayList<>();
    }

    private static DefaultOrderManagementService instance;

    private DefaultOrderManagementService() {
    }

    public static OrderManagementService getInstance() {
        if (instance == null) {
            instance = new DefaultOrderManagementService();
        }
        return instance;
    }

    @Override
    public void addOrder(Order order) {
        if (order == null) return;

        orders.add(order);
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        int amountOfUserOrders = 0;
        for (Order order : orders) {
            if (order != null && order.getCustomerId() == userId) {
                amountOfUserOrders++;
            }
        }

        List<Order> userOrders = new ArrayList<>();

        int index = 0;
        for (Order order : orders) {
            if (order != null && order.getCustomerId() == userId) {
                userOrders.add(order);
            }
        }
        return userOrders;
    }

    @Override
    public List<Order> getOrders() {
        return this.orders;
    }

    void clearServiceState() {
        orders.clear();
    }
}
