package org.example.springcourse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;                                                 //Model - класс Spring-a
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam (value = "name", required = false) String name,
                            @RequestParam (value = "surname", required = false) String surname,
                            Model model) {                                             //Spring автоматически внедрит Model model

        model.addAttribute("message", "Hello " + name + " " + surname);          // добавляем ключ - значение


        return "first/hello";                                     // Model model будет передана в представление view
    }

    @GetMapping("/goodbue")
    public String goodBuePage() {
        return "first/goodbue";                                    // html-страница будет находиться в папке first, goodbue -> goodbue.html
    }
}
