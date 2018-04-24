package com.morgen.controller;

import com.morgen.service.CalculatorService;
import com.morgen.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import javax.validation.Valid;

@Controller
public class CalculatorController {


    private final Logger LOGGER = LoggerFactory.getLogger(CalculatorController.class);
    private final CalculatorService calculatorService;

    @Inject
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @RequestMapping("/add")
    private String add(Model model, @RequestParam(value = "firstArgument") @Valid Integer firstArgument,
                       @RequestParam(value = "secondArgument") @Valid Integer secondArgument) {
        int result = calculatorService.add(firstArgument, secondArgument);
        LOGGER.info("First argument: {}, second argument {}, action - add,result: {},result", firstArgument, secondArgument, result);
        model.addAttribute("firstArgument", firstArgument);
        model.addAttribute("secondArgument", secondArgument);
        model.addAttribute("sum", result);
        return "add";
    }


    //TODO доделать методы под веб интерфейс

    @RequestMapping("/subtract")
    private Response subtract(@RequestParam(value = "firstArgument") @Valid Integer firstArgument,
                              @RequestParam(value = "secondArgument") @Valid Integer secondArgument) {
        return new Response(calculatorService.subtract(firstArgument, secondArgument));
    }

    @RequestMapping("/multiply")
    private Response multiply(@RequestParam(value = "firstArgument") @Valid Integer firstArgument,
                              @RequestParam(value = "secondArgument") @Valid Integer secondArgument) {
        return new Response(calculatorService.multiply(firstArgument, secondArgument));
    }

    @RequestMapping("/divide")
    private Response divide(@RequestParam(value = "firstArgument") @Valid Double firstArgument,
                            @RequestParam(value = "secondArgument") @Valid Double secondArgument) {
        return new Response(calculatorService.divide(firstArgument, secondArgument));
    }


}
