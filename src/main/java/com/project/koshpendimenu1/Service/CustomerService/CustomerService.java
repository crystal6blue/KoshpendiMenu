package com.project.koshpendimenu1.Service.CustomerService;

import com.project.koshpendimenu1.Model.Customer;
import com.project.koshpendimenu1.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Add a new customer
    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Update an existing customer
    @Override
    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        if (customerRepository.existsById(id)) {
            updatedCustomer.setId(id);
            return customerRepository.save(updatedCustomer);
        }
        return null; // or throw an exception if the customer does not exist
    }

    // Delete a customer by ID
    @Override
    public void deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        }
    }

    // Fetch a customer by ID
    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    // Fetch all customers
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}

