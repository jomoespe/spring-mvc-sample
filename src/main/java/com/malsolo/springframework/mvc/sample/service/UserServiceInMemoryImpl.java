package com.malsolo.springframework.mvc.sample.service;

import com.malsolo.springframework.mvc.sample.domain.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;

/**
 *
 * @author jbeneito
 */
@Service
public class UserServiceInMemoryImpl implements UserService {
    
    private static final int INITIAL_NUMBER_OF_USERS = 5;
    
    private final Map<Long, User> users;
    private final AtomicLong idGenerator;

    public UserServiceInMemoryImpl() {
        this.idGenerator = new AtomicLong();
        this.users = new HashMap<>();
        for (int i = 0; i < INITIAL_NUMBER_OF_USERS; i++) {
            Long id = this.idGenerator.getAndIncrement();
            User user = new User();
            user.setId(id);
            user.setName("Name " + i);
            user.setEmail("name"+i+"@user.com");
            user.setPhone(String.valueOf(i));
            users.put(id, user);
        }
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User find(Long id) {
        return this.users.get(id);
    }

    @Override
    public User create() {
        User user = new User();
        Long id = this.idGenerator.getAndIncrement();
        user.setId(id);
        users.put(id, user);
        return user;
    }
    
}
