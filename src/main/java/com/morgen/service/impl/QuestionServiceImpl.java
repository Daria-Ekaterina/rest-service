package com.morgen.service.impl;

import com.morgen.bean.Question;
import com.morgen.repository.QuestionRepository;
import com.morgen.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository repository;

    @Override
    public List<Question> findAll() {
        List<Question> questions = (List<Question>) repository.findAll();

        return questions;
    }

//    @Override
//    public void save(Question question) {
//        repository.save(question);
//    }

//    @Service
//    public class CityService implements ICityService {
//
//        @Autowired
//        private CityRepository repository;
//
//        @Override
//        public List<City> findAll() {
//
//            List<City> cities = (List<City>) repository.findAll();
//
//            return cities;
//        }
//    }
}