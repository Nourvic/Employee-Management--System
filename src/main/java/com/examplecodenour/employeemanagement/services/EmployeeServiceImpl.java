package com.examplecodenour.employeemanagement.services;

import com.examplecodenour.employeemanagement.abstracts.EmployeeService;
import com.examplecodenour.employeemanagement.entities.Employee;
import com.examplecodenour.employeemanagement.shared.CustomResponseException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>();

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee findOne(UUID employeeId) {
        return employees.stream()
                .filter(e -> e.getId()
                        .equals(employeeId))
                .findFirst()
                .orElseThrow(() -> CustomResponseException
                        .ResourceNotFound("Employee id with " + employeeId + " not found"));

        //   Employee emp = employees.stream() ................ Logik ->>> BlaBLaBla
//      Or if (emp.isEmpty()) {
//            throw CustomResponseException.ResourceNotFound("Employee id with " + employeeId + " not found");
//        }
    }

}
