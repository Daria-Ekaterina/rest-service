package com.morgen.service;

public interface CalculatorService {
    int add(Integer firstArgument, Integer secondArgument);

    int subtract(Integer firstArgument, Integer secondArgument);

    int multiply(Integer firstArgument, Integer secondArgument);

    double divide(Double firstArgument, Double secondArgument);
}
