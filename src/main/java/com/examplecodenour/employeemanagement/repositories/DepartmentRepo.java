package com.examplecodenour.employeemanagement.repositories;

import com.examplecodenour.employeemanagement.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@org.springframework.stereotype.Repository
public interface DepartmentRepo extends JpaRepository<Department, UUID> {
}
