package com.examplecodenour.employeemanagement.controller;

import com.examplecodenour.employeemanagement.dto.SignupRequest;
import com.examplecodenour.employeemanagement.services.AuthService;
import com.examplecodenour.employeemanagement.shared.GlobalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<GlobalResponse<String>> signUp(@RequestBody SignupRequest signupRequest) {
        authService.signUp(signupRequest);
        return new ResponseEntity<>(new GlobalResponse<>("Signed Up"), HttpStatus.OK);
    }
}
