package com.morgen.service.impl;

import com.morgen.service.CalculatorService;
import org.springframework.stereotype.Service;

@Service ("calculator")
public class CalculatorServiceImpl implements CalculatorService {
    private int firstArgument;
    private int secondArgument;

    public int getFirstArgument() {
        return firstArgument;
    }

    public void setFirstArgument(int firstArgument) {
        this.firstArgument = firstArgument;
    }

    public int getSecondArgument() {
        return secondArgument;
    }

    public void setSecondArgument(int secondArgument) {this.secondArgument = secondArgument;}

    @Override
    public int add(Integer firstArgument, Integer secondArgument) {
        return firstArgument + secondArgument;
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
        return firstArgument / secondArgument;
    }
}
