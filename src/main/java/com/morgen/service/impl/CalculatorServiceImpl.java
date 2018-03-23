package com.morgen.service.impl;

import org.springframework.stereotype.Service;
import com.morgen.service.CalculatorService;


@Service("CalculatorService")
public class CalculatorServiceImpl implements CalculatorService {
    private int arg1;
    private int arg2;
    private int sum;


//    public CalculatorServiceImpl(int arg1, int arg2) {
//        this.arg1 = arg1;
//        this.arg2 = arg2;
//    }

   // @Override
    public void add() {
        sum=arg1+arg2;
        System.out.println(sum);
    }

    public int getArg1() {
        return arg1;
    }

    public int getArg2() {
        return arg2;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public void add(int arg1, int arg2) {
        sum=arg1+arg2;
        System.out.println(sum);
    }
}
