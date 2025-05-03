package com.project.koshpendimenu1.Controller;

import com.project.koshpendimenu1.Model.OrderItem;
import com.project.koshpendimenu1.Service.OrderItemService.IOrderItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/order-items")  // Base URL for order item-related endpoints
public class OrderItemController {

    private final IOrderItemService orderItemService;

    public OrderItemController(IOrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    // Add a new order item
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderItem addOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.addOrderItem(orderItem);
    }

    // Get an order item by ID
    @GetMapping("/{id}")
    public Optional<OrderItem> getOrderItemById(@PathVariable Long id) {
        return orderItemService.getOrderItemById(id);
    }

    // Get all order items
    @GetMapping
    public Iterable<OrderItem> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    // Update an existing order item
    @PutMapping("/{id}")
    public OrderItem updateOrderItem(@PathVariable Long id, @RequestBody OrderItem updatedOrderItem) {
        return orderItemService.updateOrderItem(id, updatedOrderItem);
    }

    // Delete an order item by ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrderItem(@PathVariable Long id) {
        orderItemService.deleteOrderItem(id);
    }
}
