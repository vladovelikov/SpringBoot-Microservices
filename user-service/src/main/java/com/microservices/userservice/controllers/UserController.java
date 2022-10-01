package com.microservices.userservice.controllers;

import com.microservices.userservice.entities.User;
import com.microservices.userservice.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User findUser(@PathVariable String id) {
        return this.userService.findUserById(id);
    }

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        return this.userService.saveUser(user);
    }
}
