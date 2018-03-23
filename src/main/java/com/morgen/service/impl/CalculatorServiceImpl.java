package com.morgen.service.impl;

import org.springframework.stereotype.Service;
import com.morgen.service.CalculatorService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service("calculatorService")
public class CalculatorServiceImpl implements CalculatorService {
//TODO add a check for NULL
    @Override
    public int add(Integer intFirstArg, Integer intSecondArg) {
        return intFirstArg + intSecondArg;
    }

    @Override
    public int subtract(Integer firstArg, Integer secondArg) {
        return firstArg - secondArg;
    }

    @Override
    public int multiply(Integer firstArg, Integer secondArg) {
        return firstArg * secondArg;
    }

    @Override
    public float divide(Integer firstArg, Integer secondArg) {
        if (secondArg != 0) {
            return (float) firstArg / secondArg;
        }
        return 0;
    }
}
