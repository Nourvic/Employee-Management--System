package com.examplecodenour.employeemanagement.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.UUID;

public record EmployeeCreate(
        @NotNull(message = "firstName ist required")
        @Size(min = 2, max = 50, message = "min is 2 characters and Max is 50 ")
        String firstName,

        @NotNull(message = "LastName ist required")
        @Size(min = 2, max = 50, message = "min is 2 characters and Max is 50 ")
        String lastName,

        @NotNull
        @Email(message = " Invalid Email format")
        String email,

        @NotNull
        @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid phone number format")
        String phoneNumber,

        @NotNull
        @PastOrPresent(message = "hire date cannot be in the future")
        LocalDate hireDate,

        @NotNull
        @Size(min = 2, max = 50)
        String position,

        @NotNull
        UUID departmentId

) {
}
