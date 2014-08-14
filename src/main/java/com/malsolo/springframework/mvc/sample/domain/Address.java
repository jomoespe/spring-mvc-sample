/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.malsolo.springframework.mvc.sample.domain;

import com.google.common.base.Objects;

/**
 *
 * @author jbeneito
 */
public class Address {
    
    private Long id;
    private String street, city, country;

    public Address() {
    }
    
    public Address(Long id, String street, String city, String country) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.country = country;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("street", street)
                .add("city", city)
                .add("country", country)
                .toString();
    }

}
