package com.project.koshpendimenu1.Repository;

import com.project.koshpendimenu1.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
