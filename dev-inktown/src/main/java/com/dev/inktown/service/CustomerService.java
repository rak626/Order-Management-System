package com.dev.inktown.service;

import com.dev.inktown.entity.Customer;
import com.dev.inktown.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;


    public Customer getCustomerById(String customerId){
        Optional<Customer> result = customerRepository.findById(customerId);
        return result.orElseGet(Customer::new);
    }
    public Customer createCustomer(Customer newCustomer){

        String customerName = newCustomer.getCustomerName();
        String customerPhn = newCustomer.getPhoneNo();
        Optional<Customer> orderFindResult = customerRepository.findByCustomerNameAndPhoneNo(customerName,customerPhn);
        return orderFindResult.orElseGet(() -> customerRepository.save(newCustomer));
    }
}
