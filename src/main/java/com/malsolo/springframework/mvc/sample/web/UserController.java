package com.malsolo.springframework.mvc.sample.web;

import com.malsolo.springframework.mvc.sample.domain.User;
import com.malsolo.springframework.mvc.sample.domain.Users;
import com.malsolo.springframework.mvc.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author jbeneito
 */
@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Users getRestUsers(Model model) {
        Users users = new Users();
        users.addUsers(userService.findAll());
        model.addAttribute("users", users);
        return users;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") long userId) {
        User user = userService.find(userId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "")
    public ResponseEntity<Void> createUser() {
        /*User user = */this.userService.create();
        
        //HttpHeaders headers = new HttpHeaders();
        //headers.setLocation(null);//37:44
        
        return new ResponseEntity<>(HttpStatus.CREATED);//(headers, HttpStatus.CREATED);
    }
    
//    @ExceptionHandler({NotExistsException.class, NotFoundxception.class})
//    ResponseEntity<String> handleNotFounds(Exception e) {
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler({IllegalArgumentException.class, NullPointerException.class})
    ResponseEntity<String> handleBadRequests(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<String> handleConflicts(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

}
