/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.malsolo.springframework.mvc.sample.web;

import com.malsolo.springframework.mvc.sample.domain.Customer;
import com.malsolo.springframework.mvc.sample.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author jbeneito
 */
@Controller
@RequestMapping("/customers")
public class CustomerController {
    
    @Autowired
    CustomerRepository customerRepository;
    
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Customer> list() {
        return customerRepository.findCustomers();
    }
    
    @RequestMapping(value = "html", method = RequestMethod.GET)
    public String list(Model uiModel) {
        uiModel.addAttribute("customerList", customerRepository.findCustomers());
        return "customers/list";
    }
}
