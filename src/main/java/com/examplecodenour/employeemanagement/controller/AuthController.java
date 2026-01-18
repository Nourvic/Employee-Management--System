package com.examplecodenour.employeemanagement.controller;

import com.examplecodenour.employeemanagement.shared.GlobalResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/signup")

    public ResponseEntity<GlobalResponse<String>> signUp() {
        return new ResponseEntity<>(new GlobalResponse<>("Signed Up"), HttpStatus.OK);
    }
}
