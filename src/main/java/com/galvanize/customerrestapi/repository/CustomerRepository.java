package com.galvanize.customerrestapi.repository;

import com.galvanize.customerrestapi.TestUtil.TestUtil;
import com.galvanize.customerrestapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , String> {

}
