package com.galvanize.customerrestapi.service;
import com.galvanize.customerrestapi.model.Customer;
import com.galvanize.customerrestapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.getCustomers();
    }

    public Customer getCustomerByID(String id) {
        return customerRepository.getCustomers().stream().filter(a->a.getId().equals(id)).collect(Collectors.toList()).get(0);
    }
}
