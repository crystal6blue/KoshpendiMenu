package com.project.koshpendimenu1.Service.OrderService;

import com.project.koshpendimenu1.Model.Orders;

import java.util.Optional;

public interface IOrderService {

    // Add a new order
    Orders addOrder(Orders order);

    // Update an existing order
    Orders updateOrder(Long id, Orders updatedOrder);

    // Delete an order by ID
    void deleteOrder(Long id);

    // Fetch an order by ID
    Optional<Orders> getOrderById(Long id);

    // Fetch all orders
    Iterable<Orders> getAllOrders();
}
