package com.dev.inktown.controller;

import com.dev.inktown.entity.Customer;
import com.dev.inktown.entity.Customer;
import com.dev.inktown.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @GetMapping("/getAll")
    public List<Customer> getAllCustomer(){
        return new ArrayList<>();
    }
    @GetMapping(value = "/getById/{customerId}")
    public Customer getCustomerById(@PathVariable("customerId") String customerId){
        return customerService.getCustomerById(customerId);
    }

    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer newCustomer) {
        Customer createdCustomer = customerService.createCustomer(newCustomer);
        return ResponseEntity.ok(createdCustomer);
    }
}
