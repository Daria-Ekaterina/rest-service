package com.morgen.controller;

import com.morgen.bean.Question;
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

    private CalculatorService service;
    private final Logger LOGGER=LoggerFactory.getLogger(CalculatorController.class);

    @Inject
    public CalculatorController(CalculatorService calculatorService) {
        this.service = calculatorService;
    }

    @Autowired
    QuestionService questionService;

    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    public String findQuestion(Model model) {
        List<Question> questions = (List<Question>) questionService.findAll();
        Question result = questions.get(terRandomQuestion(questions.size()));
        LOGGER.info(result.getName());
        model.addAttribute("question", result);
        return "questions";
    }

    @RequestMapping(value = "/question/add", method = RequestMethod.POST)
    public String addQuestion(@RequestBody Question question) {
        Question question1=new Question();
        questionService.addQuestion(question1);
        return null;
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
