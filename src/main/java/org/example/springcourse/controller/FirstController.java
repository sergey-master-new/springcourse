package org.example.springcourse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/first")         //добавится в адрес url
public class FirstController {

    @GetMapping("/hello")
    public String helloPage() {

        return "first/hello";     //html-страница будет находиться в папке first, hello -> hello.html
    }

    @GetMapping("/goodbue")
    public String goodBuePage() {

        return "first/goodbue";  //html-страница будет находиться в папке first, goodbue -> goodbue.html
    }
}
