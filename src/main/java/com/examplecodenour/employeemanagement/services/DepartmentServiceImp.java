package com.examplecodenour.employeemanagement.services;

import com.examplecodenour.employeemanagement.abstracts.DepartmentService;
import com.examplecodenour.employeemanagement.entities.Department;
import com.examplecodenour.employeemanagement.repositories.DepartmentRepo;
import com.examplecodenour.employeemanagement.shared.CustomResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private DepartmentRepo DepartmentRepo;
    @Autowired
    private DepartmentRepo departmentRepo;


    @Override
    public Department findOne(UUID departmentId) {
        return departmentRepo.findById(departmentId)
                .orElseThrow(() -> CustomResponseException
                        .ResourceNotFound("DepartmentId " + departmentId + "not found"));
    }

    @Override
    public List<Department> findAll() {
        return departmentRepo.findAll();
    }

    @Override
    public Department createOne(Department department) {
        Department department1 = new Department();
        department1.setDepartmentName(department.getDepartmentName());
        return departmentRepo.save(department1);
    }

    @Override
    public void deleteOne(UUID departmentId) {
    }


}
