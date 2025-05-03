package com.project.koshpendimenu1.Repository;

import com.project.koshpendimenu1.Model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
