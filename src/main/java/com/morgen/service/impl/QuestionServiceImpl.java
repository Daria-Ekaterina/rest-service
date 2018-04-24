package com.morgen.service.impl;

import com.morgen.model.Question;
import com.morgen.repository.QuestionRepository;
import com.morgen.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionServiceImpl.class);

    private final QuestionRepository repository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.repository=questionRepository;
    }

    @Override
    public List<Question> findAll() {
        LOGGER.info("START repo findall");
        List<Question> questions = (List<Question>) repository.findAll();
        LOGGER.info("END repo");
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questions = findAll();
        return questions.get(getRandomNum(questions));
    }

    private int getRandomNum(List<Question> sizeArrayOfQuestion){
        return (int) (Math.random() * sizeArrayOfQuestion.size());
    }

    @Override
    public Question addQuestion(Question question) {
        //TODO сделать валидацию на поля
        LOGGER.info("Question name from ServiceImpl= {}",question.getName());
        repository.save(question);
        return question;
    }
}