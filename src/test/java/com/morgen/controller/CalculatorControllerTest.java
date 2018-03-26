package com.morgen.controller;

import com.morgen.service.CalculatorService;
import com.morgen.service.impl.CalculatorServiceImpl;
import org.junit.After;

import org.junit.Before;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;


import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class CalculatorControllerTest {
//    private CalculatorController calculatorController;
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Before
//    public void init() {
//   //     calculatorController = new CalculatorController(new CalculatorServiceImpl());
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }
//
//    @Test
//    public void andGetRwsponse() throws Exception {
//        this.mockMvc.perform(get("/add")).andDo(print()).andExpect(status().isOk())
//                .andExpect(jsonPath("").value("Hello, World!"));
//    }
}