package com.examplecodenour.employeemanagement.services;

import com.examplecodenour.employeemanagement.abstracts.EmployeeService;
import com.examplecodenour.employeemanagement.dto.EmployeeCreate;
import com.examplecodenour.employeemanagement.dto.EmployeeUpdate;
import com.examplecodenour.employeemanagement.entities.Employee;
import com.examplecodenour.employeemanagement.repositories.EmployeeRepo;
import com.examplecodenour.employeemanagement.shared.CustomResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findOne(UUID employeeId) {
        return employeeRepo.findById(employeeId)
                .orElseThrow(() -> CustomResponseException
                        .ResourceNotFound("Employee with id " + employeeId + " not found"));
    }

    @Override
    public void deleteOne(UUID employeeId) {
        Employee emp = employeeRepo.findById(employeeId)
                .orElseThrow(() -> CustomResponseException
                        .ResourceNotFound("Employee with" + employeeId + "not found"));
        //employeeRepo.delete(emp);
        employeeRepo.deleteById(employeeId);
    }

    @Override
    public Employee createOne(EmployeeCreate employeeDto) {
        Employee empl = new Employee();
        empl.setFirstName(employeeDto.firstName());
        empl.setLastName(employeeDto.lastName());
        empl.setEmail(employeeDto.email());
        empl.setPhoneNumber(employeeDto.phoneNumber());
        empl.setPosition(employeeDto.position());
        empl.setHireDate(employeeDto.hireDate());
        employeeRepo.save(empl);
        return empl;
    }

    @Override
    public Employee updateOne(UUID employeeId, EmployeeUpdate employee) {
        Employee excemp = employeeRepo.findById(employeeId)
                .orElseThrow(() -> CustomResponseException
                        .ResourceNotFound("Employee with" + employeeId + "not found"));
        // employees.stream().filter(e -> e.getId().equals(employeeId)).findFirst().orElseThrow(() -> CustomResponseException.ResourceNotFound("Employee id with " + employeeId + " not found"));
        excemp.setFirstName(employee.firstName());
        excemp.setLastName(employee.lastName());
        excemp.setPhoneNumber(employee.phoneNumber());
        excemp.setPosition(employee.position());
        return employeeRepo.save(excemp);
    }
}
