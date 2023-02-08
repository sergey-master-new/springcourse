package org.example.springcourse.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public String calculate(int a, int b, String action) {

        double result;

        switch (action) {
            case "additional":
                result = a + b;
                break;
            case "multiplication":
                result = a * b;
                break;
            case "substraction":
                result = a - b;
                break;
            case "division":
                result = a / (double) b;  //чтобы получить вещественное число, а не целое
                break;
            default:
                result = 0;
        }

        return String.format("%.2f",result);
    }
}
