/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malsolo.springframework.mvc.sample.repository;

import com.malsolo.springframework.mvc.sample.domain.Address;
import com.malsolo.springframework.mvc.sample.domain.Customer;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jbeneito
 */
@Repository
public class CustomerRepositoryInMemoryImpl implements CustomerRepository {

    private static final int INITIAL_NUMBER_OF_CLIENTS = 10;
    private static final int MAX_RANDOM_ADDRESSES_FOR_CUSTOMER = 3;
    private static final SecureRandom RANDOM = new SecureRandom();

    private final Map<Long, Customer> customers;
    private final AtomicLong idGeneratorForCustomer;
    private final AtomicLong idGeneratorForAddress;
    private final Object monitor = new Object();

    @PostConstruct
    public void postConstructMethod() {
        System.err.printf("----- postConstructMethod() called for %s. Available customers %s\n", this.getClass().getName(), (customers==null?"null":String.valueOf(customers.size())));
    }

    public CustomerRepositoryInMemoryImpl() {
        this.idGeneratorForCustomer = new AtomicLong();
        this.idGeneratorForAddress = new AtomicLong();
        this.customers = new HashMap<>();
        for (int i = 0; i < INITIAL_NUMBER_OF_CLIENTS; i++) {
            Long id = idGeneratorForCustomer.getAndIncrement();
            customers.put(id, new Customer(id, "firstname " + i, "lastname " + i, createAddresses()));
        }
    }

    private Set<Address> createAddresses() {
        Set<Address> addresses = new HashSet<>();
        int number = RANDOM.nextInt(MAX_RANDOM_ADDRESSES_FOR_CUSTOMER);
        for (int i = 0; i < number; i++) {
            addresses.add(new Address(idGeneratorForAddress.getAndDecrement(), "street " + i, "city " + i, "country " + i));
        }
        return addresses;
    }

    @Override
    public List<Customer> findCustomers() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer create(Customer customer) {
        synchronized (this.monitor) {
            Long id = idGeneratorForCustomer.getAndIncrement();
            customer.setId(id);
            this.customers.put(id, customer);
        }
        return customer;
    }

    @Override
    public Customer retrieve(Long id) {
        synchronized (this.monitor) {
            return this.customers.get(id);
        }
    }

    @Override
    public void remove(Long id) {
        synchronized (this.monitor) {
            this.customers.remove(id);
        }
    }

}
