package com.project.koshpendimenu1.Repository;


import com.project.koshpendimenu1.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
