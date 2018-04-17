package com.morgen.service.impl;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class CalculatorServiceImplTest {
    private CalculatorServiceImpl calculatorService;

    @Before
    public void init() {
        calculatorService = new CalculatorServiceImpl();
    }


    @Test
    public void addReturnsSumOfTwoArguments() {
        calculatorService.add(6, 2);
        Assert.assertEquals(8, calculatorService.add(6, 2));
    }

    @Test
    public void subtractReturnsDifferenceOfTwoArguments() {
        calculatorService.subtract(6, 2);
        Assert.assertEquals(4, calculatorService.subtract(6, 2));
    }

    @Test
    public void multiplyReturnsCompositionOfTwoArguments() {
        calculatorService.multiply(6, 2);
        Assert.assertEquals(12, calculatorService.multiply(6, 2));
    }

    @Test
    public void divideReturnedQuotientOfTwoArguments() {
        calculatorService.divide(6.0, 2.0);
        Assert.assertEquals(3.0, calculatorService.divide(6.0, 2.0), 0.0);
    }
}