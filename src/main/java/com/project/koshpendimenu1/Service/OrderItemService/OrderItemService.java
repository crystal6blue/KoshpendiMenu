package com.project.koshpendimenu1.Service.OrderItemService;

import com.project.koshpendimenu1.Model.OrderItem;
import com.project.koshpendimenu1.Repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderItemService implements IOrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    // Add a new order item
    @Override
    public OrderItem addOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    // Update an existing order item
    @Override
    public OrderItem updateOrderItem(Long id, OrderItem updatedOrderItem) {
        if (orderItemRepository.existsById(id)) {
            updatedOrderItem.setId(id);
            return orderItemRepository.save(updatedOrderItem);
        }
        return null; // or throw an exception if the order item does not exist
    }

    // Delete an order item by ID
    @Override
    public void deleteOrderItem(Long id) {
        if (orderItemRepository.existsById(id)) {
            orderItemRepository.deleteById(id);
        }
    }

    // Fetch an order item by ID
    @Override
    public Optional<OrderItem> getOrderItemById(Long id) {
        return orderItemRepository.findById(id);
    }

    // Fetch all order items
    @Override
    public Iterable<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }


}

