package com.malsolo.springframework.mvc.sample.repository;

import com.malsolo.springframework.mvc.sample.domain.Customer;
import java.util.List;

/**
 *
 * @author jbeneito
 */
public interface CustomerRepository {
    
    List<Customer> findCustomers();
    
    Customer create(Customer customer);

    Customer retrieve(Long id);

    void remove(Long id);
    
    
}
