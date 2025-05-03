package com.project.koshpendimenu1.Service.OrderItemService;

import com.project.koshpendimenu1.Model.OrderItem;

import java.util.Optional;

public interface IOrderItemService {

    // Add a new order item
    OrderItem addOrderItem(OrderItem orderItem);

    // Update an existing order item
    OrderItem updateOrderItem(Long id, OrderItem updatedOrderItem);

    // Delete an order item by ID
    void deleteOrderItem(Long id);

    // Fetch an order item by ID
    Optional<OrderItem> getOrderItemById(Long id);

    // Fetch all order items
    Iterable<OrderItem> getAllOrderItems();
}
