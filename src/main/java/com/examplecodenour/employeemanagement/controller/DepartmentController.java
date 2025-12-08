package com.examplecodenour.employeemanagement.controller;

import com.examplecodenour.employeemanagement.abstracts.DepartmentService;
import com.examplecodenour.employeemanagement.dto.DepartemntCreate;
import com.examplecodenour.employeemanagement.entities.Department;
import com.examplecodenour.employeemanagement.shared.GlobalResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping()
    public ResponseEntity<GlobalResponse<List<Department>>> findAll() {
        return new ResponseEntity<>(new GlobalResponse<>(departmentService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<GlobalResponse<Department>> findOne(@PathVariable UUID departmentId) {
        Department demp = departmentService.findOne(departmentId);

        return new ResponseEntity<>(new GlobalResponse<>(demp), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<GlobalResponse<Department>> createOne(@Valid @RequestBody DepartemntCreate department) {
        return new ResponseEntity<>(new GlobalResponse<>(departmentService.createOne(department)), HttpStatus.CREATED);
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<Void> deleteOne(@PathVariable UUID departmentId) {
        departmentService.deleteOne(departmentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
