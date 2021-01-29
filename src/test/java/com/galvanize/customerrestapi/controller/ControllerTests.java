package com.galvanize.customerrestapi.controller;

import TestUtil.TestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.customerrestapi.model.Customer;
import com.galvanize.customerrestapi.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(Controller.class)
public class ControllerTests {
@MockBean
private CustomerService service;
@Autowired
private MockMvc mockMvc;
@InjectMocks
private Controller controller;
    @BeforeEach
    public void init(){
        controller= new Controller();
    }

    @Test
    public void testGetAllCustomers() throws Exception {
        when(service.getAllCustomers()).thenReturn(TestUtil.getListOfCustomers());

        mockMvc.perform(get("/api/customers"))
                .andExpect(status().is(200))
                .andReturn();
    }
    @Test
    public void testGetCustomerByID() throws Exception {
        Customer customer= TestUtil.getACustomer();
        String id=customer.getId();

        when(service.getCustomerByID(any())).thenReturn(customer);

        mockMvc.perform(get("/api/customers/"+id))
                .andExpect(status().is(200))
                .andExpect(jsonPath("firstName").value("Amir"))
                .andReturn();
    }

    @Test
    public void testAddCustomer() throws Exception {

        Customer customer = new Customer("bob", "marley","801323423","dallas");

        when(service.addCustomer(any(Customer.class))).thenReturn(customer);

        ObjectMapper mapper = new ObjectMapper();

        String postedJson = mapper.writeValueAsString(customer);
        mockMvc
                .perform(post("/api/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postedJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("bob"))
                .andExpect(jsonPath("$.lastName").value("marley"))
                .andReturn();
    }
}
