package com.project.koshpendimenu1.Service.CustomerService;

import com.project.koshpendimenu1.Model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    public Customer addCustomer(Customer customer);

    public Customer updateCustomer(Long id, Customer updatedCustomer);

    public void deleteCustomer(Long id);

    public Optional<Customer> getCustomerById(Long id);

    public List<Customer> getAllCustomers();
}
