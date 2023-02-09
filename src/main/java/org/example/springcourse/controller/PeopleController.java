package org.example.springcourse.controller;

import org.example.springcourse.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private PersonDao personDao;

    @Autowired                                         //с конструктором без разницы, есть @Autowired или нет
    public PeopleController(PersonDao personDao) {
        this.personDao = personDao;                    //лучше конструктор, чем @Autowired
    }

    @GetMapping()
    public String index(Model model){

        model.addAttribute("people", personDao.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,
                        Model model){

        model.addAttribute("person", personDao.show(id));
        return "people/show";
    }
}
