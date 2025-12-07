package com.examplecodenour.employeemanagement.abstracts;

import com.examplecodenour.employeemanagement.entities.Department;

import java.util.List;
import java.util.UUID;

public interface DepartmentService {
    Department findOne(UUID departmentId);

    List<Department> findAll();

    Department createOne(Department department);

    void deleteOne(UUID departmentId);
    
}
