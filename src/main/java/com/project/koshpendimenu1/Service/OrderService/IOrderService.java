package com.project.koshpendimenu1.Service.OrderService;

import com.project.koshpendimenu1.Model.Order;

import java.util.Optional;

public interface IOrderService {

    // Add a new order
    Order addOrder(Order order);

    // Update an existing order
    Order updateOrder(Long id, Order updatedOrder);

    // Delete an order by ID
    void deleteOrder(Long id);

    // Fetch an order by ID
    Optional<Order> getOrderById(Long id);

    // Fetch all orders
    Iterable<Order> getAllOrders();
}
