package com.examplecodenour.employeemanagement.services;

import com.examplecodenour.employeemanagement.abstracts.LeaveRequestService;
import com.examplecodenour.employeemanagement.dto.LeaveRequestCreate;
import com.examplecodenour.employeemanagement.entities.Employee;
import com.examplecodenour.employeemanagement.entities.LeaveRequest;
import com.examplecodenour.employeemanagement.repositories.EmployeeRepo;
import com.examplecodenour.employeemanagement.shared.CustomResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LeaveRequestImp implements LeaveRequestService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public LeaveRequest createOne(LeaveRequestCreate leaveRequestCreate, UUID employeeId) {
        Employee emp = employeeRepo.findById(employeeId)
                .orElseThrow(() -> CustomResponseException.
                        ResourceNotFound("Employee with id " + employeeId + " not found"));

        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setStatus("PEDNING !");
        leaveRequest.setReason(leaveRequestCreate.reason());
        leaveRequest.setStartDate(leaveRequestCreate.startDate());
        leaveRequest.setEndDate(leaveRequestCreate.endDate());
        leaveRequest.setEmployee(emp);

        return leaveRequest;
    }

    @Override
    public List<LeaveRequest> findAllEmployeeById(UUID employeeId) {
        return null;
    }
}
