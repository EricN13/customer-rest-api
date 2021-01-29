package com.galvanize.customerrestapi.service;
import com.galvanize.customerrestapi.model.Customer;
import com.galvanize.customerrestapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerByID(String id) {
        return customerRepository.findById(id).get();
    }

    public Customer addCustomer(Customer customer) {
        return this.customerRepository.save(customer);
    }

    public Customer updateCustomer(String customerId, Customer customer) {

        Optional<Customer> customerData  = this.customerRepository.findById(customerId);

        if(customerData.isPresent()){
            customer.setId(customerId);
            return this.customerRepository.save(customer);
        }else{
            return null;
        }
    }


    public void deleteCustomerById(String customerId) throws Exception {
        this.customerRepository.deleteById(customerId);
    }
}
