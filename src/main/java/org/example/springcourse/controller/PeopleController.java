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
//    public String newPerson(Model model){                            // ниже пример с @ModelAttribute
//
//        model.addAttribute("person", new Person());
//        return "people/new";
//    }

    @GetMapping("/new")                                                 // Пример с @ModelAttribute
    public String newPerson(@ModelAttribute("person") Person person){   // 1. Создание объекта new Person()
                                                                        // 2. В поля ничего не передаем, будут значения по умолчанию
        return "people/new";                                            // 3. Объект person добавляем в модель как атрибут
    }

//    @PostMapping()
//    public String create(@RequestParam String name){            //ниже пример с @ModelAttribute, лучший вариант
//
//        Person person = new Person();
//        person.setName(name);
//        personDao.save(person);
//        return "redirect:/people";
//    }

    @PostMapping()
    public String create(@ModelAttribute("person") Person person){

        personDao.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){

        model.addAttribute(personDao.show(id));
        return "/people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") Person person, @PathVariable("id") int id){

        personDao.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){

        personDao.delete(id);
        return "redirect:/people";
    }
}
