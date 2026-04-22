package com.example.calculator;

public record CalculationResponse(
        double firstNumber,
        String operator,
        double secondNumber,
        double result
) {
}
