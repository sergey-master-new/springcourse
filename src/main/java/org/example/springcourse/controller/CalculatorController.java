package org.example.springcourse.controller;

import org.example.springcourse.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller                                       // test http://localhost:8080/calculator/get?a=5&b=5&action=additional
@RequestMapping("/calculator")                    // test http://localhost:8080/calculator/get?a=5&b=2&action=division
public class CalculatorController {

    @Autowired
    private CalculatorService service;

    @GetMapping("/get")
    public String calculate(@RequestParam(value = "a", required = true) int a,
                            @RequestParam(value = "b", required = true) int b,
                            @RequestParam(value = "action", required = true) String action,
                            Model model) {                                    //Spring автоматически внедрит Model model

        String resultOfAction = service.calculate(a, b, action);
        model.addAttribute("result", "Result = " + resultOfAction);     // добавляем ключ - значение

        return "calculator/calc";                                             // Model model будет передана в представление view
    }
}
