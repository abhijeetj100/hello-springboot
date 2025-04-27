package com.example.hellospringboot.utility;

import org.springframework.stereotype.Component;

@Component
public class MathUtility {
    public int addTwoNums(int a, int b) {
        return a + b;
    }
}
