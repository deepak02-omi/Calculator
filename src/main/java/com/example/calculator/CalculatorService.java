package com.example.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public CalculationResponse calculate(double firstNumber, String operator, double secondNumber) {
        if (operator == null || operator.isBlank()) {
            throw new IllegalArgumentException("operator is required");
        }

        double result = switch (operator) {
            case "+", "add" -> firstNumber + secondNumber;
            case "-", "subtract" -> firstNumber - secondNumber;
            case "*", "multiply" -> firstNumber * secondNumber;
            case "/", "divide" -> {
                if (secondNumber == 0) {
                    throw new IllegalArgumentException("division by zero is not allowed");
                }
                yield firstNumber / secondNumber;
            }
            default -> throw new IllegalArgumentException("operator must be one of +, -, *, /, add, subtract, multiply, divide");
        };

        return new CalculationResponse(firstNumber, operator, secondNumber, result);
    }
}
