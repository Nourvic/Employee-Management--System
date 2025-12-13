package com.examplecodenour.employeemanagement.abstracts;

import com.examplecodenour.employeemanagement.dto.LeaveRequestCreate;
import com.examplecodenour.employeemanagement.entities.LeaveRequest;

import java.util.List;
import java.util.UUID;

public interface LeaveRequestService {

    LeaveRequest createOne(LeaveRequestCreate leaveRequest, UUID employeeId);

    List<LeaveRequest> findAllEmployeeById(UUID employeeId);
}
