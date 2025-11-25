package com.examplecodenour.employeemanagement.controller;

import com.examplecodenour.employeemanagement.entities.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    List<Employee> employees = new ArrayList(List.of(new Employee(UUID.randomUUID(), "Nour", "Salim", "noursalim@gmail.com", "017297xxxx", LocalDate.now(), "DevOps", UUID.randomUUID()), new Employee(UUID.randomUUID(), "Mohamad", "Salim", "mohamadsalim@gmail.com", "017297xxxx", LocalDate.now(), "Cyber", UUID.randomUUID())

    ));

    @GetMapping()
    public List<Employee> HelloWold() {
        return employees;
    }

    @GetMapping("/{employeeId}")
    public Optional<Employee> findOne(@PathVariable UUID employeeId) {
        Optional<Employee> emp = employees.stream().filter(e -> e.getId().equals(employeeId)).findFirst();
        return emp;
    }

    @GetMapping("hello")
    public String hello() {
        return "Hello Spring-boot";
    }
}
