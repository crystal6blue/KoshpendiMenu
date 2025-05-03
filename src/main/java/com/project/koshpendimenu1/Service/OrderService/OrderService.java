package com.project.koshpendimenu1.Service.OrderService;


import com.project.koshpendimenu1.Model.Orders;
import com.project.koshpendimenu1.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Add a new order
    @Override
    public Orders addOrder(Orders order) {
        return orderRepository.save(order);
    }

    // Update an existing order
    @Override
    public Orders updateOrder(Long id, Orders updatedOrder) {
        if (orderRepository.existsById(id)) {
            updatedOrder.setId(id);
            return orderRepository.save(updatedOrder);
        }
        return null; // or throw an exception if the order does not exist
    }

    // Delete an order by ID
    @Override
    public void deleteOrder(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
        }
    }

    // Fetch an order by ID
    @Override
    public Optional<Orders> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    // Fetch all orders
    @Override
    public Iterable<Orders> getAllOrders() {
        return orderRepository.findAll();
    }
}
