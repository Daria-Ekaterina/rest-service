package com.morgen.controller;

import com.morgen.model.Question;
import com.morgen.model.Theme;
import com.morgen.service.QuestionService;
import com.morgen.service.ThemeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.List;

@RequestMapping("/questions")
@Controller
public class QuestionsController {

    private final Logger LOGGER = LoggerFactory.getLogger(QuestionsController.class);
    private final QuestionService questionService;
    private final ThemeService themeService;

    @Inject
    public QuestionsController(QuestionService questionService, ThemeService themeService) {
        this.questionService = questionService;
        this.themeService = themeService;
    }

    // CRUD
    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public String findQuestion(Model model) {
        Question result = questionService.getRandomQuestion();
        LOGGER.info("Get random question from list: {}", result.getName());
        model.addAttribute("question", result);
        return "randomquestions";
    }

    @RequestMapping(value = "/showallquestions", method = RequestMethod.GET)
    public String showAllQuestions(Model model) {
        List<Question> questions = questionService.findAll();
        LOGGER.info("Get all questions from list: {}", questions);
        model.addAttribute("question", questions);
        return "showallquestions";
    }

    @RequestMapping(value = "/addquestion", method = RequestMethod.GET)
    public String addQuestion(Model model) {
        model.addAttribute("question", new Question());
        return "addquestion";
    }

    @RequestMapping(value = "/addquestion", method = RequestMethod.POST)
    public String addQuestion(@ModelAttribute Question question, Model model) {
        questionService.addQuestion(question);
        model.addAttribute("question", question);
        return "result";
    }


    @RequestMapping(value = "/addtheme", method = RequestMethod.GET)
    public String addTheme(Model model) {
        model.addAttribute("theme", new Theme());
        return "addtheme";
    }

    @RequestMapping(value = "/addtheme", method = RequestMethod.POST)
    public String addQuestion(@ModelAttribute Theme theme, Model model) {
        themeService.addTheme(theme);
        model.addAttribute("theme", theme);
        return "result";
    }
}
