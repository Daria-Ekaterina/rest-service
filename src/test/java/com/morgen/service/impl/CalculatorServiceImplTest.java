package com.morgen.service.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorServiceImplTest {
    private CalculatorServiceImpl calculatorService;

    @Before
    public void init() {
        calculatorService = new CalculatorServiceImpl();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add_6_plus_2_8returned() {
        calculatorService.add(6, 2);
        Assert.assertEquals(8, calculatorService.add(6, 2));
    }

    @Test
    public void subtract_6_minus_2_4returned() {
        calculatorService.subtract(6, 2);
        Assert.assertEquals(4, calculatorService.subtract(6, 2));
    }

    @Test
    public void multiply_6_times_2_12returned() {
        calculatorService.multiply(6, 2);
        Assert.assertEquals(12, calculatorService.multiply(6, 2));
    }

    @Test
    public void divide_6_divided_2_3returned() {
        calculatorService.divide(6.0, 2.0);
        Assert.assertEquals(3.0, calculatorService.divide(6.0, 2.0), 0.0);
    }
}