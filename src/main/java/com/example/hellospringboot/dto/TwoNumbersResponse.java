package com.example.hellospringboot.dto;

public class TwoNumbersResponse {
    private int result;

    public TwoNumbersResponse() {
    }

    public TwoNumbersResponse(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
