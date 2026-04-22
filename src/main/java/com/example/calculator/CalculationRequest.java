package com.example.calculator;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CalculationRequest(
        @NotNull(message = "firstNumber is required")
        Double firstNumber,
        @NotBlank(message = "operator is required")
        String operator,
        @NotNull(message = "secondNumber is required")
        Double secondNumber
) {
}
