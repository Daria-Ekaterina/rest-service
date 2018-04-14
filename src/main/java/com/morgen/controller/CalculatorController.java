package com.morgen.controller;

import com.morgen.bean.Question;
import com.morgen.service.QuestionService;
import com.morgen.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.morgen.service.CalculatorService;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

@RestController
public class CalculatorController {
    private CalculatorService service;

    @Inject
    public CalculatorController(CalculatorService calculatorService) {
        this.service = calculatorService;
    }

    @Autowired
    QuestionService cityService;

    @RequestMapping("/questions")
    public String findCities(Model model) {

        List<Question> questions = (List<Question>) cityService.findAll();
        Question result = questions.get(terRandomQuestion(questions.size()));
        System.out.println(result);
        model.addAttribute("question", result);

        return "questions";
    }

    private int terRandomQuestion(int size) {
        return (int) (Math.random()*size);
    }
    //TODO добавить result перемменную, для передачи в качестве параметра Response
    //TODO покрыть tests

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
