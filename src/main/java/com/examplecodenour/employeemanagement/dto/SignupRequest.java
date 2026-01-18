package com.examplecodenour.employeemanagement.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record SignupRequest(
        @NotNull(message = "username is required")
        @Size(min = 2, max = 50, message = "Min 2 max 50 characters")
        String username,

        @NotNull(message = "password is required")
        @Size(min = 8, max = 50, message = "between 8 and 50 ")
        String password,

        @NotNull(message = "employee id is required")
        String employeeId
) {
}
