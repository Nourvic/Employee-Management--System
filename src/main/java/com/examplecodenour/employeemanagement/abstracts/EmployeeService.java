package com.examplecodenour.employeemanagement.abstracts;

import com.examplecodenour.employeemanagement.entities.Employee;

import java.util.List;
import java.util.UUID;


public interface EmployeeService {
    List<Employee> findAll();

    Employee findOne(UUID employeeId);

    void deleteOne(UUID employeeId);

    Employee createOne(Employee employee);

    Employee updateOne(UUID employeeId, Employee employee);

}
