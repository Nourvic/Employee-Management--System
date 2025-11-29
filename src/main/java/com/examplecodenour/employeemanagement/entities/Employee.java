package com.examplecodenour.employeemanagement.entities;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Employee {
    private UUID id;
    @NotNull(message = "firstName ist required")
    @Size(min = 2, max = 50, message = "min is 2 characters and Max is 50 ")
    private String firstName;
    @NotNull(message = "LastName ist required")
    @Size(min = 2, max = 50, message = "min is 2 characters and Max is 50 ")
    private String lastName;
    @NotNull
    @Email(message = " Invalid Email format")
    private String email;
    @NotNull
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid phone number format")
    private String phoneNumber;
    @NotNull
    @PastOrPresent(message = "hire date cannot be in the future")
    private LocalDate hireDate;
    @NotNull
    private String position;
    private UUID departmentId;
}
