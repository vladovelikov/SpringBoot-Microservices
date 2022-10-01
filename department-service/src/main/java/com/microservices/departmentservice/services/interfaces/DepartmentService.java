package com.microservices.departmentservice.services.interfaces;

import com.microservices.departmentservice.entities.Department;

public interface DepartmentService {
    Department saveDepartment(Department department);

    Department findDepartmentById(String id);

}
