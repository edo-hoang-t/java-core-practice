package com.edocode.oop.exam.services;

import com.edocode.oop.exam.entities.Order;

public interface OrderManagementService {

    void addOrder(Order order);

    Order[] getOrdersByUserId(int userId);

    Order[] getOrders();
}
