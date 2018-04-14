package com.morgen.controller;

import com.morgen.bean.Question;
import com.morgen.service.CalculatorService;
import com.morgen.service.QuestionService;
import com.morgen.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

@Controller
public class CalculatorController {

    private CalculatorService service;

    @Inject
    public CalculatorController(CalculatorService calculatorService) {
        this.service = calculatorService;
    }

    @Autowired
    QuestionService questionService;

    @RequestMapping("/questions")
    public String findQuestion(Model model) {
        List<Question> questions = (List<Question>) questionService.findAll();
        Question result = questions.get(terRandomQuestion(questions.size()));
        model.addAttribute("question", result);
        return "questions";
    }

    private int terRandomQuestion(int size) {
        return (int) (Math.random() * size);
    }
    //TODO добавить result перемменную, для передачи в качестве параметра Response
    //TODO покрыть tests

    @RequestMapping("/add")
    private String add(Model model, @RequestParam(value = "firstArgument") @Valid Integer firstArgument,
                       @RequestParam(value = "secondArgument") @Valid Integer secondArgument) {
        model.addAttribute("firstArgument", firstArgument);
        model.addAttribute("secondArgument", secondArgument);
        model.addAttribute("sum", service.add(firstArgument, secondArgument));
        return "add";
    }

    //TODO доделать методы под веб интерфейс

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
