package com.morgen.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.morgen.service.CalculatorService;

import javax.inject.Inject;

@RestController
public class CalculatorController {
    private CalculatorService service;

    @Inject
    public CalculatorController(CalculatorService calculatorService) {
        this.service = calculatorService;
    }

    @RequestMapping("/add")
    //@RequestParam(value = "arg1") int arg1, @RequestParam(value = "arg2") int arg2
    private void add(@RequestParam(value = "arg1") int arg1, @RequestParam(value = "arg2") int arg2){
        service.add(arg1,arg2);
    }

}
