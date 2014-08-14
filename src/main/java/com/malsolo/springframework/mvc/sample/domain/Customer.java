/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.malsolo.springframework.mvc.sample.domain;

import com.google.common.base.Objects;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author jbeneito
 */
public class Customer {
    
    private Long id;
    private String firstname, lastname;
    private Set<Address> addresses = new HashSet<>();

    public Customer() {
    }

    public Customer(Long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }
    
    public Customer(Long id, String firstname, String lastname, Set<Address> addresses) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.addresses = addresses;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
    
    public int getAddressesNumber() {
        return this.addresses==null?-1:addresses.size();
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("firstname", firstname)
                .add("lastname", lastname)
                .add("addresses", addresses)
                .toString();
    }
    
}
