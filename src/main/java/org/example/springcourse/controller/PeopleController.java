package org.example.springcourse.controller;

import org.example.springcourse.dao.PersonDao;
import org.example.springcourse.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping("/new")
//    public String newPerson(Model model){
//
//        model.addAttribute("person", new Person());
//        return "people/new";
//    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person){

        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") Person person){

        personDao.save(person);
        return "redirect:/people";
    }

}
