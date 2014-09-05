package com.malsolo.springframework.mvc.sample.web;

import com.malsolo.springframework.mvc.sample.domain.Customer;
import com.malsolo.springframework.mvc.sample.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jbeneito
 */
@Controller
@RequestMapping("/customerscontent")
public class CustomerController {
    
    @Autowired
    CustomerRepository customerRepository;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> list() {
        return customerRepository.findCustomers();
    }
    
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model uiModel) {
        uiModel.addAttribute("customerList", customerRepository.findCustomers());
        return "customers/list";
    }
}
