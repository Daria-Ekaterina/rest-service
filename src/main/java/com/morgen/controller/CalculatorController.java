package com.morgen.controller;

import com.morgen.utils.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.morgen.service.CalculatorService;

import javax.inject.Inject;
import javax.validation.Valid;

@RestController
public class CalculatorController {
    private CalculatorService service;

    @Inject
    public CalculatorController(CalculatorService calculatorService) {
        this.service = calculatorService;
    }

    //TODO добавить result перемменную, для передачи в качестве параметра Response
    //TODO покрыть тестами

    @RequestMapping("/add")
    private Response add(@RequestParam(value = "firstArgument") @Valid Integer firstArgument,
                         @RequestParam(value = "secondArgument") @Valid Integer secondArgument) {
        return new Response(service.add(firstArgument, secondArgument));
    }

    @RequestMapping("/subtract")
    private Response subtract(@RequestParam(value = "firstArgument") @Valid Integer firstArgument,
                              @RequestParam(value = "secondArgument") @Valid Integer secondArgument) {
        return new Response(service.subtract(firstArgument, secondArgument));
    }

    @RequestMapping("/multiply")
    private Response multiply(@RequestParam(value = "firstArgument") @Valid Integer firstArgument,
                              @RequestParam(value = "secondArgument") @Valid Integer secondArgument) {
        return new Response(service.multiply(firstArgument, secondArgument));
    }

    @RequestMapping("/divide")
    private Response divide(@RequestParam(value = "firstArgument") @Valid Double firstArgument,
                            @RequestParam(value = "secondArgument") @Valid Double secondArgument) {
        return new Response(service.divide(firstArgument, secondArgument));
    }
}
