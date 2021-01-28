package com.galvanize.customerrestapi.controller;

import com.galvanize.customerrestapi.model.Customer;
import com.galvanize.customerrestapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class Controller {
    @Autowired
    private CustomerService service;
    @GetMapping
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }
    @GetMapping("/{customerId}")
    public Customer getCustomerByID(@PathVariable("customerId") String customerId){

        return this.service.getCustomerByID(customerId);
    }
}
