package com.security.hashing;
//Controller.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()

public class Controller {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/api")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {

        try {
            if(!(user.getUsername().isEmpty() || user.getPassword().isEmpty())) {
                return userService.saveUser(user.getUsername(), user.getPassword());
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        try {
            if(userService.login(user.getUsername(), user.getPassword())) {
                return "Welcome " + user.getUsername();
            }
            else
            {
                return "Invalid username or password";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
