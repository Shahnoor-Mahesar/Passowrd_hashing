package com.security.hashing;

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

        return userService.saveUser(user.getUsername(), user.getPassword());
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        if(userService.login(user.getUsername(), user.getPassword())) {
            return "Welcome " + user.getUsername();
        }
        else
        {
            return "Invalid username or password";
        }

    }

}
