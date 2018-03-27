package com.morgen.controller;

import com.morgen.service.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

@Controller
public class CalculatorController {
    //TODO покрыть тестами
   // private CalculatorService service;
    private Calculator calculator;

    @Inject
    public CalculatorController(Calculator calculator){
        this.calculator = calculator;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView add() {
        return new ModelAndView("add", "command", calculator); //WTF magic??
    }

    @RequestMapping(value = "subtract", method = RequestMethod.GET)
    public ModelAndView subtract() {
        return new ModelAndView("subtract", "command", calculator); //WTF magic??
    }

    @RequestMapping(value = "multiply", method = RequestMethod.GET)
    public ModelAndView multiply() {
        return new ModelAndView("multiply", "command", calculator); //WTF magic??
    }

    @RequestMapping(value = "divide", method = RequestMethod.GET)
    public ModelAndView divide() {
        return new ModelAndView("divide", "command", calculator); //WTF magic??
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("mvc-dispatcher") Calculator calculator,
                      ModelMap model) {
        model.addAttribute("firstArgument", calculator.getFirstArgument());
        model.addAttribute("secondArgument", calculator.getSecondArgument());
        model.addAttribute("result",
                calculator.add(calculator.getFirstArgument(), calculator.getSecondArgument()));
        return "result";
    }

    @RequestMapping(value = "/subtract", method = RequestMethod.POST)
    public String subtract(@ModelAttribute("mvc-dispatcher") Calculator calculator,
                           ModelMap model) {
        model.addAttribute("firstArgument", calculator.getFirstArgument());
        model.addAttribute("secondArgument", calculator.getSecondArgument());
        model.addAttribute("result",
                calculator.subtract(calculator.getFirstArgument(), calculator.getSecondArgument()));
        return "result";
    }

    @RequestMapping(value = "/multiply", method = RequestMethod.POST)
    public String multiply(@ModelAttribute("mvc-dispatcher") Calculator calculator,
                           ModelMap model) {
        model.addAttribute("firstArgument", calculator.getFirstArgument());
        model.addAttribute("secondArgument", calculator.getSecondArgument());
        model.addAttribute("result",
                calculator.multiply(calculator.getFirstArgument(), calculator.getSecondArgument()));
        return "result";
    }

    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    public String divide(@ModelAttribute("mvc-dispatcher") Calculator calculator,
                         ModelMap model) {
        model.addAttribute("firstArgument", calculator.getFirstArgument());
        model.addAttribute("secondArgument", calculator.getSecondArgument());
        model.addAttribute("result",
                calculator.divide((double) calculator.getFirstArgument(), (double) calculator.getSecondArgument()));
        return "result";
    }

}
