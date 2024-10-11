package com.example.demo.services;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    public Customer registerCustomer(Customer customer)
    {
        return customerRepo.save(customer);
    }
    public Customer loginCustomer(String email, String password)
    {
        return customerRepo.findByEmailAndPassword(email, password);
    }
}
