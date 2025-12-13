package com.examplecodenour.employeemanagement.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record LeaveRequestCreate(

        @NotNull(message = "Start date is required")
        @FutureOrPresent(message = "start date should be now or in the future")
        LocalDate startDate,

        @NotNull(message = "End date is required")
        @FutureOrPresent(message = "End date should be now or in the future")
        LocalDate endDate,

        @NotNull(message = "reason ist required")
        @Size(min = 2, max = 50, message = "reason is 2 characters and Max is 50 ")
        String reason
) {
}
