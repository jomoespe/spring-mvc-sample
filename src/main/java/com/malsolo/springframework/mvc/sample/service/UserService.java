/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.malsolo.springframework.mvc.sample.service;

import com.malsolo.springframework.mvc.sample.domain.User;
import java.util.List;

/**
 *
 * @author jbeneito
 */
public interface UserService {
    
    public List<User> findAll();
    
    public User find(Long id);
    
    public User create();

}
