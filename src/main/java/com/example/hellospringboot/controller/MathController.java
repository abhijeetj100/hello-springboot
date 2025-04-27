package com.example.hellospringboot.controller;

import com.example.hellospringboot.dto.TwoNumbersRequest;
import com.example.hellospringboot.dto.TwoNumbersResponse;
import com.example.hellospringboot.utility.MathUtility;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    private MathUtility mathUtility;

    public MathController(MathUtility mathUtility) {
        this.mathUtility = mathUtility;
    }

    @PostMapping("/add")
    public ResponseEntity<TwoNumbersResponse> addTwoNumbers(@Valid @RequestBody TwoNumbersRequest request) {
        return ResponseEntity.ok(
                new TwoNumbersResponse(mathUtility.addTwoNums(request.getNumOne(), request.getNumTwo()))
        );
    }
}
