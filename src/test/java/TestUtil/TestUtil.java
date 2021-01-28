package TestUtil;

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

}
