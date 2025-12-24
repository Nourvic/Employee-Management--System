package com.examplecodenour.employeemanagement.controller;

import com.examplecodenour.employeemanagement.abstracts.EmployeeService;
import com.examplecodenour.employeemanagement.abstracts.LeaveRequestService;
import com.examplecodenour.employeemanagement.dto.EmployeeCreate;
import com.examplecodenour.employeemanagement.dto.EmployeeUpdate;
import com.examplecodenour.employeemanagement.dto.LeaveRequestCreate;
import com.examplecodenour.employeemanagement.entities.Employee;
import com.examplecodenour.employeemanagement.entities.LeaveRequest;
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
    @Autowired
    private LeaveRequestService leaveRequestService;
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
    public ResponseEntity<GlobalResponse<EmployeeCreate>> createOne(@Valid @RequestBody EmployeeCreate employee) {
        Employee emp = employeeService.createOne(employee);
        return new ResponseEntity<>(new GlobalResponse<>(employee), HttpStatus.CREATED);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteOne(@PathVariable UUID employeeId) {
        employeeService.deleteOne(employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateOne(@PathVariable UUID employeeId, @Valid @RequestBody EmployeeUpdate employee) {
        Employee excemp = employeeService.updateOne(employeeId, employee);

        return new ResponseEntity<>(excemp, HttpStatus.OK);
    }

    @PostMapping("/{employeeId}/leave-request")
    public ResponseEntity<GlobalResponse<LeaveRequest>> leaveRequetsCreate(@RequestBody @Valid LeaveRequestCreate leaveRequest, @PathVariable UUID employeeId) {

        LeaveRequest newleaveRequst = leaveRequestService.createOne(leaveRequest, employeeId);

        return new ResponseEntity<>(new GlobalResponse<>(newleaveRequst), HttpStatus.OK);
    }

    @GetMapping("/{employeeId}/leave-requests")
    public ResponseEntity<GlobalResponse<List<LeaveRequest>>> leaveRequestsByEmployeeId(@PathVariable UUID employeeId) {
        List<LeaveRequest> lereq = leaveRequestService.findAllEmployeeById(employeeId);
        return new ResponseEntity<>(new GlobalResponse<>(lereq), HttpStatus.OK);
    }
}