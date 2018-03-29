package com.morgen.controller;

import com.morgen.service.CalculatorService;
import com.morgen.service.impl.CalculatorServiceImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.inject.Inject;

@Controller
public class CalculatorController {
    private CalculatorService calculatorService;
//    private static final Logger logger =
//            LoggerFactory.getLogger(CalculatorController.class);

    @Inject
    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView add() {
        return new ModelAndView("add", "command", calculatorService); //WTF magic??
    }

    @RequestMapping(value = "subtract", method = RequestMethod.GET)
    public ModelAndView subtract() {
        return new ModelAndView("subtract", "command", calculatorService); //WTF magic??
    }

    @RequestMapping(value = "multiply", method = RequestMethod.GET)
    public ModelAndView multiply() {
        return new ModelAndView("multiply", "command", calculatorService); //WTF magic??
    }

    @RequestMapping(value = "divide", method = RequestMethod.GET)
    public ModelAndView divide() {
        return new ModelAndView("divide", "command", calculatorService); //WTF magic??
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("mvc-dispatcher") CalculatorServiceImpl calculatorServiceImpl,
                      ModelMap model) {
        model.addAttribute("firstArgument", calculatorServiceImpl.getFirstArgument());
        model.addAttribute("secondArgument", calculatorServiceImpl.getSecondArgument());
        model.addAttribute("result",
                calculatorServiceImpl.add(calculatorServiceImpl.getFirstArgument(), calculatorServiceImpl.getSecondArgument()));
        return "result";
    }

    @RequestMapping(value = "/subtract", method = RequestMethod.POST)
    public String subtract(@ModelAttribute("mvc-dispatcher") CalculatorServiceImpl calculatorServiceImpl,
                           ModelMap model) {
        model.addAttribute("firstArgument", calculatorServiceImpl.getFirstArgument());
        model.addAttribute("secondArgument", calculatorServiceImpl.getSecondArgument());
        model.addAttribute("result",
                calculatorServiceImpl.subtract(calculatorServiceImpl.getFirstArgument(), calculatorServiceImpl.getSecondArgument()));
        return "result";
    }

    @RequestMapping(value = "/multiply", method = RequestMethod.POST)
    public String multiply(@ModelAttribute("mvc-dispatcher") CalculatorServiceImpl calculatorServiceImpl,
                           ModelMap model) {
        model.addAttribute("firstArgument", calculatorServiceImpl.getFirstArgument());
        model.addAttribute("secondArgument", calculatorServiceImpl.getSecondArgument());
        model.addAttribute("result",
                calculatorServiceImpl.multiply(calculatorServiceImpl.getFirstArgument(), calculatorServiceImpl.getSecondArgument()));
        return "result";
    }

    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    public String divide(@ModelAttribute("mvc-dispatcher") CalculatorServiceImpl calculatorServiceImpl,
                         ModelMap model) {
        model.addAttribute("firstArgument", calculatorServiceImpl.getFirstArgument());
        model.addAttribute("secondArgument", calculatorServiceImpl.getSecondArgument());
        model.addAttribute("result",
                calculatorServiceImpl.divide((double) calculatorServiceImpl.getFirstArgument(), (double) calculatorServiceImpl.getSecondArgument()));
        return "result";
    }

}
