package com.examplecodenour.employeemanagement.repositories;

import com.examplecodenour.employeemanagement.entities.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LeaveRequestRepo extends JpaRepository<LeaveRequest, UUID> {
}
