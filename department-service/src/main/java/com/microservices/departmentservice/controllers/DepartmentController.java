package com.microservices.departmentservice.controllers;

import com.microservices.departmentservice.entities.Department;
import com.microservices.departmentservice.services.interfaces.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}")
    public Department findDepartment(@PathVariable String id) {
        return this.departmentService.findDepartmentById(id);
    }

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }
}
