package com.morgen.controller;

import com.morgen.model.Question;
import com.morgen.service.CalculatorService;
import com.morgen.service.QuestionService;
import com.morgen.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

@Controller
public class CalculatorController {

    private final CalculatorService calculatorService;
    private final Logger LOGGER=LoggerFactory.getLogger(CalculatorController.class);

    @Autowired
    private QuestionService questionService;

    @Inject
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    public String findQuestion(Model model) {
        List<Question> questions = questionService.findAll();
        Question result = questions.get(getRandomQuestion(questions.size()));
        LOGGER.info("Get random question from list: {}",result.getName());
        model.addAttribute("question", result);
        return "questions";
    }

    @RequestMapping(value = "/question/add", method = RequestMethod.POST)
    public String addQuestion(@RequestBody Question question) {
        return null;
    }


    private int getRandomQuestion(int size) {
        return (int) (Math.random() * size);
    }
    //TODO добавить result перемменную, для передачи в качестве параметра Response
    //TODO покрыть tests

    @RequestMapping("/add")
    private String add(Model model, @RequestParam(value = "firstArgument") @Valid Integer firstArgument,
                       @RequestParam(value = "secondArgument") @Valid Integer secondArgument) {
        int result=calculatorService.add(firstArgument,secondArgument);
        LOGGER.info("First argument: {}, second argument {}, action - add,result: {},result",firstArgument,secondArgument,result);
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
