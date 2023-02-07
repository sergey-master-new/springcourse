package org.example.springcourse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")         //добавится в адрес url
public class FirstController {

    @GetMapping("/hello")                                    //напр., http://localhost:8080/first/hello?name=Ivan&surname=Ivanov
    public String helloPage(HttpServletRequest request) {    //c HttpServletRequest у нас полный доступ к запросу
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println("Hello " + name + " " + surname);  //Hello Ivan Ivanov
                                                              // если http://localhost:8080/first/hello ,то Hello null null

        return "first/hello";     //html-страница будет находиться в папке first, hello -> hello.html
    }

    @GetMapping("/goodbue")                                     //напр.,http://localhost:8080/first/goodbue?name=Ivan&surname=Ivanov
    public String goodBuePage(@RequestParam String name,
                              @RequestParam (value = "surname", required = false) String surname) {   //surname - можно не указывать

        System.out.println("Goodbue " + name + " " + surname);  // Goodbue Ivan Ivanov
                                                                // ошибка 400 – Bad Request, если http://localhost:8080/first/goodbue
                                                                // Goodbue Ivan null, если http://localhost:8080/first/goodbue?name=Ivan

        return "first/goodbue";  //html-страница будет находиться в папке first, goodbue -> goodbue.html
    }
}
