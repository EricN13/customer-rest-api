package com.galvanize.customerrestapi.TestUtil;

import com.galvanize.customerrestapi.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class TestUtil {

    private static List<Customer> customers = new ArrayList<>();
    private static Customer customer=new Customer();
    public static List<Customer> getListOfCustomers(){
        customers.add(new Customer("Amir","Wondimu","6418221111","Dallas"));
        customers.add(new Customer("Bob","smile","6819191111","Chicago"));
        return customers;
    }

    public static Customer getACustomer(){
        customer=new Customer("Amir","Wondimu","6418221111","Dallas");
        return customer;
    }

    public Customer addCustomer(Customer customer){
        customers.add(customer);
        return customer;
    }

    public Customer deleteCustomerById(String customerId) throws Exception {
        Customer removedCustomer = null;
        for(Customer cust : getListOfCustomers()){
            if(cust.getId().equals(customerId)){
                removedCustomer = cust;
                customers.remove(cust);
                return removedCustomer;
            }else{
                throw new Exception("No customer with the provided ID");
            }
        }
        return null;
    }

}
