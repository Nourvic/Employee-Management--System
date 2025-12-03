package com.examplecodenour.employeemanagement.abstracts;

import com.examplecodenour.employeemanagement.dto.EmployeeCreate;
import com.examplecodenour.employeemanagement.dto.EmployeeUpdate;
import com.examplecodenour.employeemanagement.entities.Employee;

import java.util.List;
import java.util.UUID;


public interface EmployeeService {
    List<Employee> findAll();

    Employee findOne(UUID employeeId);

    void deleteOne(UUID employeeId);

    Employee createOne(EmployeeCreate employee);

    Employee updateOne(UUID employeeId, EmployeeUpdate employee);

}
