package com.microservices.departmentservice.services;

import com.microservices.departmentservice.entities.Department;
import com.microservices.departmentservice.exceptions.DepartmentNotFoundException;
import com.microservices.departmentservice.repositories.DepartmentRepository;
import com.microservices.departmentservice.services.interfaces.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department saveDepartment(Department department) {
        return this.departmentRepository.save(department);
    }

    @Override
    public Department findDepartmentById(Long id) {
        return this.departmentRepository.findById(id);
    }
}
