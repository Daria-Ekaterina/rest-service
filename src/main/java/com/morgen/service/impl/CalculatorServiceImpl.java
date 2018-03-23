package com.morgen.service.impl;

import org.springframework.stereotype.Service;
import com.morgen.service.CalculatorService;


@Service("CalculatorService")
public class CalculatorServiceImpl implements CalculatorService {

    private int sum;


    public int getSum() {
        return sum;
    }

    @Override
    public void add(int arg1, int arg2) {
        sum=arg1+arg2;
        System.out.println(sum);
    }
}
