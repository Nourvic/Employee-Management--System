package com.examplecodenour.employeemanagement.services;

import com.examplecodenour.employeemanagement.abstracts.EmployeeService;
import com.examplecodenour.employeemanagement.dto.EmployeeCreate;
import com.examplecodenour.employeemanagement.dto.EmployeeUpdate;
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

    @Override
    public void deleteOne(UUID employeeId) {
        Optional<Employee> emp = employees
                .stream().
                filter(e -> e.getId().equals(employeeId))
                .findFirst();
        emp.ifPresent(e -> employees.remove(e));
    }

    @Override
    public Employee createOne(EmployeeCreate employeeDto) {
        Employee empl = new Employee();
        empl.setId(UUID.randomUUID());
        empl.setDepartmentId(UUID.randomUUID());
        empl.setFirstName(employeeDto.firstName());
        empl.setLastName(employeeDto.lastName());
        empl.setEmail(employeeDto.email());
        empl.setPhoneNumber(employeeDto.phoneNumber());
        empl.setPosition(employeeDto.position());
        empl.setHireDate(employeeDto.hireDate());
        employees.add(empl);
        return empl;
    }

    @Override
    public Employee updateOne(UUID employeeId, EmployeeUpdate employee) {
        Employee excemp = employees.stream()
                .filter(e -> e.getId().equals(employeeId))
                .findFirst()
                .orElseThrow(() -> CustomResponseException
                        .ResourceNotFound("Employee id with " + employeeId + " not found"));

        excemp.setFirstName(employee.firstName());
        excemp.setLastName(employee.lastName());
        excemp.setPhoneNumber(employee.phoneNumber());
        excemp.setPosition(employee.position());
        return excemp;
    }
}
