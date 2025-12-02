package com.examplecodenour.employeemanagement.controller;

import com.examplecodenour.employeemanagement.abstracts.EmployeeService;
import com.examplecodenour.employeemanagement.entities.Employee;
import com.examplecodenour.employeemanagement.shared.GlobalResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

//    public EmployeeController(EmployeeService employeeService) {
//        this.employeeService = employeeService;
//    }

    @GetMapping()
    public ResponseEntity<GlobalResponse<List<Employee>>> findAll() {
        // ResponseEntity status vom Code kontrollieren falls beispielsweise ein Angestellter nicht vorhanden dann kann ich 404 schreiben
        return new ResponseEntity<>(new GlobalResponse<>(employeeService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<GlobalResponse<Employee>> findOne(@PathVariable UUID employeeId) {
        Employee emp = employeeService.findOne(employeeId);

        return new ResponseEntity<>(new GlobalResponse<>(emp), HttpStatus.OK);

    }

    @PostMapping()
    public ResponseEntity<GlobalResponse<Employee>> createOne(@Valid @RequestBody Employee employee) {
        Employee emp = employeeService.createOne(employee);
        return new ResponseEntity<>(new GlobalResponse<>(employee), HttpStatus.CREATED);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteOne(@PathVariable UUID employeeId) {
        employeeService.deleteOne(employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*
    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateOne(@PathVariable UUID employeeId, @Valid @RequestBody Employee employee) {
        Employee excemp = employees.stream().filter(e -> e.getId().equals(employeeId)).findFirst().orElseThrow(() -> CustomResponseException.ResourceNotFound("Employee id with " + employeeId + " not found"));

        excemp.setFirstName(employee.getFirstName());
        excemp.setLastName(employee.getLastName());
        excemp.setEmail(employee.getEmail());
        excemp.setPhoneNumber(employee.getPhoneNumber());
        excemp.setPosition(employee.getPosition());
        excemp.setHireDate(employee.getHireDate());
        excemp.setDepartmentId(employee.getDepartmentId());
        return new ResponseEntity<>(excemp, HttpStatus.OK);
    }

     */
}