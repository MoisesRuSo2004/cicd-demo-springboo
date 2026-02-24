package com.example.taller.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSumWithNegativeNumbers() throws Exception {
        mockMvc.perform(get("/api/sum")
                .param("a", "-5")
                .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("-2"));
    }

    @Test
    void testMultiplyWithZero() throws Exception {
        mockMvc.perform(get("/api/multiply")
                .param("a", "0")
                .param("b", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    @Test
    void testSumMissingParam() throws Exception {
        mockMvc.perform(get("/api/sum")
                .param("a", "5"))
                .andExpect(status().isBadRequest());
    }
}