package com.example.hellospringboot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

public class TwoNumbersRequest {
    @NotNull(message="numOne is required")
    private int numOne;

    @NotNull(message="numTwo is required")
    private int numTwo;

    public int getNumOne() {
        return numOne;
    }

    public void setNumOne(int num) {
        this.numOne = num;
    }

    public int getNumTwo() {
        return numTwo;
    }

    public void setNumTwo(int num) {
        this.numTwo = num;
    }

}
