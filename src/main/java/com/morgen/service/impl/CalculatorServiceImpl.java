package com.morgen.service.impl;

import org.springframework.stereotype.Service;
import com.morgen.service.CalculatorService;

@Service("calculatorService")
public class CalculatorServiceImpl implements CalculatorService {

//TODO add a check for NULL

    @Override
    public int add(Integer FirstArgument, Integer SecondArgument) {
        return FirstArgument + SecondArgument;
    }

    @Override
    public int subtract(Integer firstArgument, Integer secondArgument) {
        return firstArgument - secondArgument;
    }

    @Override
    public int multiply(Integer firstArgument, Integer secondArgument) {
        return firstArgument * secondArgument;
    }

    @Override
    public double divide(Double firstArgument, Double secondArgument) {
        if (secondArgument != 0) {
            return (double) firstArgument / secondArgument;
        }
        return 0.0;
    }
}


