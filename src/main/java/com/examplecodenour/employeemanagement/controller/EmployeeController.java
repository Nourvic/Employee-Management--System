package com.examplecodenour.employeemanagement.controller;

import com.examplecodenour.employeemanagement.entities.Employee;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    List<Employee> employees = new ArrayList(List.of(new Employee(UUID.randomUUID(), "Nour", "Salim", "noursalim@gmail.com", "017297xxxx", LocalDate.now(), "DevOps", UUID.randomUUID()), new Employee(UUID.randomUUID(), "Mohamad", "Salim", "mohamadsalim@gmail.com", "017297xxxx", LocalDate.now(), "Cyber", UUID.randomUUID())));

    @GetMapping()
    public List<Employee> HelloWold() {
        return employees;
    }

    @GetMapping("/{employeeId}")
    public Optional<Employee> findOne(@PathVariable UUID employeeId) {
        //Optional<Employee> emp = employees.stream().filter(e -> e.getId().equals(employeeId)).findFirst();
        return employees.stream().filter(e -> e.getId().equals(employeeId)).findFirst();
    }

    @PostMapping()
    public Employee createOne(@RequestBody Employee employee) {
        employee.setId(UUID.randomUUID());
        employee.setDepartmentId(UUID.randomUUID());
        employees.add(employee);
        return employee;
    }

    @DeleteMapping("/{employeeId}")
    public void deleteOne(@PathVariable UUID employeeId) {
        Optional<Employee> emp = employees.stream().filter(e -> e.getId().equals(employeeId)).findFirst();

        if (emp.isPresent()) {
            employees.remove(emp.get());
        }
    }
}
