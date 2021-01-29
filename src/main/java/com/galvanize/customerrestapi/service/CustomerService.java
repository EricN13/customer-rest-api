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

    public Customer addCustomer(Customer customer) {
        return this.customerRepository.addCustomer(customer);
    }

    public Customer updateCustomer(String customerId, Customer customer) throws Exception {
        List<Customer> customers = this.customerRepository.getCustomers();
        for(Customer cust : customers){
            if(cust.getId().equals(customerId)){
                customer.setId(customerId);
                return  this.customerRepository.addCustomer(customer);

            }
            else{
               throw new Exception("No customer with the provided ID");
            }
        }
        return null;
    }

    public Customer deleteCustomerById(String customerId) throws Exception {
        return this.customerRepository.deleteCustomerById(customerId);
    }
}
