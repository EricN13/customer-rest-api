package com.galvanize.customerrestapi.controller;

import com.galvanize.customerrestapi.model.Customer;
import com.galvanize.customerrestapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return this.service.addCustomer(customer);
    }

    @PutMapping("/{customerId}")
    public Customer updateExistingCustomer(@PathVariable String customerId,@RequestBody Customer customer) throws Exception {
        return this.service.updateCustomer(customerId,customer);
    }

    @DeleteMapping("/{customerId}")
    public void deleteExistingCustomerById(@PathVariable String customerId) throws Exception {
        this.service.deleteCustomerById(customerId);
    }
}
