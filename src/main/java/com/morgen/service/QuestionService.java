package com.morgen.service;

import com.morgen.model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> findAll();

    Question addQuestion(Question question);

    Question getRandomQuestion();
}
