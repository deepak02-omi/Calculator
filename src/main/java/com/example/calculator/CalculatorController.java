package com.example.calculator;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/")
    public Map<String, Object> home() {
        return Map.of(
                "message", "calculator api is running",
                "endpoints", new String[]{"/health", "/calculate"}
        );
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "ok");
    }

    @GetMapping("/calculate")
    public CalculationResponse calculate(
            @RequestParam double firstNumber,
            @RequestParam String operator,
            @RequestParam double secondNumber
    ) {
        return calculatorService.calculate(firstNumber, operator, secondNumber);
    }

    @PostMapping("/calculate")
    public CalculationResponse calculate(@Valid @RequestBody CalculationRequest request) {
        return calculatorService.calculate(request.firstNumber(), request.operator(), request.secondNumber());
    }
}
