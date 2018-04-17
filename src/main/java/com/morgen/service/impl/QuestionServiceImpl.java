package com.morgen.service.impl;

import com.morgen.model.Question;
import com.morgen.repository.QuestionRepository;
import com.morgen.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionServiceImpl.class);

    @Autowired
    private QuestionRepository repository;

    @Override
    public List<Question> findAll() {
        List<Question> questions = (List<Question>) repository.findAll();

        return questions;
    }

    @Override
    public Question addQuestion(Question question) {
        //TODO сделать валидацию на поля
        LOGGER.info("Question name from ServiceImpl= {}",question.getName());
        repository.save(question);
        return null;
    }
}