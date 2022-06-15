package com.edocode.oop.exam.services.impl;

import com.edocode.oop.exam.entities.Order;
import com.edocode.oop.exam.services.OrderManagementService;
import com.edocode.oop.exam.services.ProductManagementService;

import java.util.Arrays;

public class DefaultOrderManagementService implements OrderManagementService {

    private static final int DEFAULT_ORDER_CAPACITY = 10;
    private int lastIndex;
    private Order[] orders;

    {
        orders = new Order[DEFAULT_ORDER_CAPACITY];
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

        if (orders.length <= lastIndex) {
            orders = Arrays.copyOf(orders, orders.length << 1);
        }
        orders[lastIndex++] = order;
    }

    @Override
    public Order[] getOrdersByUserId(int userId) {
        int amountOfUserOrders = 0;
        for (Order order : orders) {
            if (order != null && order.getCustomerId() == userId) {
                amountOfUserOrders++;
            }
        }

        Order[] userOrders = new Order[amountOfUserOrders];

        int index = 0;
        for (Order order : orders) {
            if (order != null && order.getCustomerId() == userId) {
                userOrders[index++] = order;
            }
        }
        return userOrders;
    }

    @Override
    public Order[] getOrders() {
        return Arrays.copyOf(orders, lastIndex);
    }

    void clearServiceState() {
        lastIndex = 0;
        orders = new Order[DEFAULT_ORDER_CAPACITY];
    }
}
