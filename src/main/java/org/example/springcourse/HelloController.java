package org.example.springcourse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Controller
public class HelloController  {

    @GetMapping("/hello")
    public String sayHello(){

        return "hello_world";               //совпадает с hello_world.html
    }
}
