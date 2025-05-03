package com.project.koshpendimenu1.Controller;

import com.project.koshpendimenu1.Model.Orders;
import com.project.koshpendimenu1.Service.OrderService.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orders")  // Base URL for order-related endpoints
public class OrderController {

    private final IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    // Add a new order
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Orders addOrder(@RequestBody Orders order) {
        return orderService.addOrder(order);
    }

    // Get an order by ID
    @GetMapping("/{id}")
    public Optional<Orders> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    // Get all orders
    @GetMapping
    public Iterable<Orders> getAllOrders() {
        return orderService.getAllOrders();
    }

    // Update an existing order
    @PutMapping("/{id}")
    public Orders updateOrder(@PathVariable Long id, @RequestBody Orders updatedOrder) {
        return orderService.updateOrder(id, updatedOrder);
    }

    // Delete an order by ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
