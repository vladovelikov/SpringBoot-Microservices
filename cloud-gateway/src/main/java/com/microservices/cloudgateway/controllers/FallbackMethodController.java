package com.microservices.cloudgateway.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackMethodController {

    @GetMapping("/departmentServiceFallback")
    private String departmentServiceFallbackMethod() {
        return "Department Service is taking longer than expected. Please try again later.";
    }

    @GetMapping("/userServiceFallback")
    private String userServiceFallbackMethod() {
        return "User Service is taking longer than expected. Please try again later.";
    }
}
