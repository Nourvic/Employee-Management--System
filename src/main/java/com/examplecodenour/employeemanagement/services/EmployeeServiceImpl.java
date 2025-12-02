package com.examplecodenour.employeemanagement.services;

import com.examplecodenour.employeemanagement.abstracts.EmployeeService;
import com.examplecodenour.employeemanagement.entities.Employee;
import com.examplecodenour.employeemanagement.shared.CustomResponseException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
        return employees.stream().filter(e -> e.getId().equals(employeeId)).findFirst().orElseThrow(() -> CustomResponseException.ResourceNotFound("Employee id with " + employeeId + " not found"));

        //   Employee emp = employees.stream() ................ Logik ->>> BlaBLaBla
//      Or if (emp.isEmpty()) {
//            throw CustomResponseException.ResourceNotFound("Employee id with " + employeeId + " not found");
//        }
    }

    @Override
    public void deleteOne(UUID employeeId) {
        Optional<Employee> emp = employees.stream().filter(e -> e.getId().equals(employeeId)).findFirst();
        emp.ifPresent(e -> employees.remove(e));
    }

    @Override
    public Employee createOne(Employee employee) {
        employee.setId(UUID.randomUUID());
        employee.setDepartmentId(UUID.randomUUID());
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee updateOne(UUID employeeId, Employee employee) {
        Employee excemp = employees.stream().filter(e -> e.getId().equals(employeeId)).findFirst().orElseThrow(() -> CustomResponseException.ResourceNotFound("Employee id with " + employeeId + " not found"));

        excemp.setFirstName(employee.getFirstName());
        excemp.setLastName(employee.getLastName());
        excemp.setEmail(employee.getEmail());
        excemp.setPhoneNumber(employee.getPhoneNumber());
        excemp.setPosition(employee.getPosition());
        excemp.setHireDate(employee.getHireDate());
        excemp.setDepartmentId(employee.getDepartmentId());
        return excemp;
    }
}
