package com.galvanize.customerrestapi.repository;

import com.galvanize.customerrestapi.TestUtil.TestUtil;
import com.galvanize.customerrestapi.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {
    private TestUtil testUtil;
    public List<Customer> getCustomers() {
        return TestUtil.getListOfCustomers();
    }
}
