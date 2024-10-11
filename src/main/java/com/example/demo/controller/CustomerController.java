package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @PostMapping("/register")
    public Customer registerCustomer(@RequestBody Customer customer)
    {
        return customerService.registerCustomer(customer);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginCustomer(@RequestBody Customer customer) {
        if (customerService.loginCustomer(customer.getEmail(), customer.getPassword()) != null) {
            return ResponseEntity.ok("success");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("failed");
        }
    }

}
