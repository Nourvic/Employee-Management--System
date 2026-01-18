package com.examplecodenour.employeemanagement.services;

import com.examplecodenour.employeemanagement.dto.SignupRequest;
import com.examplecodenour.employeemanagement.entities.UserAccount;
import com.examplecodenour.employeemanagement.repositories.UserAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserAccountRepo userAccountRepo;


    public void signUp(SignupRequest signupRequest) {
        UserAccount userAccount = new UserAccount();

    }
}
