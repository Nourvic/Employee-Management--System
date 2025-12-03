package com.examplecodenour.employeemanagement.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record EmployeeUpdate(
        @NotNull(message = "firstName ist required")
        @Size(min = 2, max = 50, message = "min is 2 characters and Max is 50 ")
        String firstName,

        @NotNull(message = "LastName ist required")
        @Size(min = 2, max = 50, message = "min is 2 characters and Max is 50 ")
        String lastName,

        @NotNull
        @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid phone number format")
        String phoneNumber,

        String position
) {
}
