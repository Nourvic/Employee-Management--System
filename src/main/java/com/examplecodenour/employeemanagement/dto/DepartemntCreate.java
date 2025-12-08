package com.examplecodenour.employeemanagement.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DepartemntCreate(
        @NotNull(message = "DepartmentName ist required")
        @Size(min = 2, max = 50, message = "min is 2 characters and Max is 50 ")
        String departmentName
) {
}
