package com.examplecodenour.employeemanagement.services;

import com.examplecodenour.employeemanagement.dto.SignupRequest;
import com.examplecodenour.employeemanagement.entities.Employee;
import com.examplecodenour.employeemanagement.entities.UserAccount;
import com.examplecodenour.employeemanagement.repositories.EmployeeRepo;
import com.examplecodenour.employeemanagement.repositories.UserAccountRepo;
import com.examplecodenour.employeemanagement.shared.CustomResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserAccountRepo userAccountRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    public void signUp(SignupRequest signupRequest) {
        Employee emp = employeeRepo.findById(signupRequest.employeeId())
                .orElseThrow(
                        () -> CustomResponseException
                                .ResourceNotFound(" emoployee Id is not available"));

        UserAccount userAccount1 = new UserAccount();
        userAccount1.setUserName(signupRequest.username());
        userAccount1.setPassword(signupRequest.password());
        userAccount1.setEmployee(emp);
        userAccountRepo.save(userAccount1);
    }
}
