package com.microservices.userservice.controllers;

import com.microservices.userservice.VO.ResponseTemplateVO;
import com.microservices.userservice.entities.User;
import com.microservices.userservice.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        return this.userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long id) {
        return this.userService.getUserWithDepartment(id);
    }
}
