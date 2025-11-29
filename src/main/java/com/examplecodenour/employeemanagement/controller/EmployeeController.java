package com.examplecodenour.employeemanagement.controller;

import com.examplecodenour.employeemanagement.entities.Employee;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Employee>> HelloWold() {
        // ResponseEntity status vom Code kontrollieren falls beispielsweise ein Angestellter nicht vorhanden dann kann ich 404 schreiben
        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> findOne(@PathVariable UUID employeeId) {
        Optional<Employee> emp = employees.stream().filter(e -> e.getId().equals(employeeId)).findFirst();
        return emp.isPresent() ? new ResponseEntity<>(emp.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<Employee> createOne(@Valid @RequestBody Employee employee) {
        employee.setId(UUID.randomUUID());
        employee.setDepartmentId(UUID.randomUUID());
        employees.add(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteOne(@PathVariable UUID employeeId) {
        Optional<Employee> emp = employees.stream().filter(e -> e.getId().equals(employeeId)).findFirst();
        emp.ifPresent(e -> employees.remove(e));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateOne(@PathVariable UUID employeeId, @Valid @RequestBody Employee employee) {
        Optional<Employee> excemp = employees.stream().filter(e -> e.getId().equals(employeeId)).findFirst();
        return excemp.map(e -> {
            e.setFirstName(employee.getFirstName());
            e.setLastName(employee.getLastName());
            e.setEmail(employee.getEmail());
            e.setPhoneNumber(employee.getPhoneNumber());
            e.setPosition(employee.getPosition());
            e.setHireDate(employee.getHireDate());
            e.setDepartmentId(employee.getDepartmentId());
            return new ResponseEntity<>(e, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
}