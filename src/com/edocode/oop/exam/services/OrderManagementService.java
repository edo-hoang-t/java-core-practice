package com.edocode.oop.exam.services;

import com.edocode.oop.exam.entities.Order;

import java.util.List;

public interface OrderManagementService {

    void addOrder(Order order);

    List<Order> getOrdersByUserId(int userId);

    List<Order> getOrders();
}
