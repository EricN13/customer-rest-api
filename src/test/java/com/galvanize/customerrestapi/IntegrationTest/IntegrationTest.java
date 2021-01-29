package com.galvanize.customerrestapi.IntegrationTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.customerrestapi.TestUtil.TestUtil;
import com.galvanize.customerrestapi.controller.Controller;
import com.galvanize.customerrestapi.model.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private Customer customer;

    private Controller controller;

    @Test
    public void testGetAllCustomers() throws Exception {

        mockMvc
                .perform(get("/api/customers"))
                .andExpect(status().is(200))
                .andReturn();
    }

    @Test
    public void testAddCustomer() throws Exception {

        customer = new Customer("bob", "marley","801323423","dallas");

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

    @Test
    public void updateExistingCustomer() throws Exception {

        Customer customer = TestUtil.getACustomer();
        String id = customer.getId();
        customer.setFirstName("Jonathan");
        customer.setAddress("Irving, Texas");
        customer.setPhoneNumber("8009008000");

        ObjectMapper mapper = new ObjectMapper();
        String postedJson = mapper.writeValueAsString(customer);


        mockMvc
                .perform(put("/api/customers/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(postedJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Jonathan"))
                .andExpect(jsonPath("$.address").value("Irving, Texas"))
                .andExpect(jsonPath("$.phoneNumber").value("8009008000"))
                .andReturn();

    }

}
