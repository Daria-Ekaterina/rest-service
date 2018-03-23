package com.morgen.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.morgen.service.CalculatorService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class CalculatorController {
    private CalculatorService service;

    @Inject
    public CalculatorController(CalculatorService calculatorService) {
        this.service = calculatorService;
    }

    @RequestMapping("/add")
    private int add(@RequestParam(value = "firstArg") @Valid Integer firstArg, @RequestParam(value = "secondArg") @Valid Integer secondArg) {
        return service.add(firstArg, secondArg);
    }

    @RequestMapping("/subtract")
    private int subtract(@RequestParam(value = "firstArg") @Valid Integer firstArg, @RequestParam(value = "secondArg") @Valid Integer secondArg) {
        return service.subtract(firstArg, secondArg);
    }

    @RequestMapping("/multiply")
    private int multiply(@RequestParam(value = "firstArg") @Valid Integer firstArg, @RequestParam(value = "secondArg") @Valid Integer secondArg) {
        return service.multiply(firstArg, secondArg);
    }

    @RequestMapping("/divide")
    private float divide(@RequestParam(value = "firstArg") @Valid Integer firstArg, @RequestParam(value = "secondArg") @Valid Integer secondArg) {
        return service.divide(firstArg, secondArg);
    }
}
