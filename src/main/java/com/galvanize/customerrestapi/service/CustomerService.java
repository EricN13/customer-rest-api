package com.galvanize.customerrestapi.service;
import com.galvanize.customerrestapi.model.Customer;
import com.galvanize.customerrestapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.getCustomers();
    }
}
