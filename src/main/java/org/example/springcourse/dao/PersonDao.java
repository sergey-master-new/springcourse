package org.example.springcourse.dao;

import org.example.springcourse.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {

    private List<Person> people;
    private static int countId;

    {
        people = new ArrayList<>();
        people.add(new Person(++countId, "Tom"));
        people.add(new Person(++countId, "Bob"));
        people.add(new Person(++countId, "Mike"));
        people.add(new Person(++countId, "Vasya"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(final int id){
        return people.stream().filter(person -> person.getId() == id).findFirst().orElse(null);
    }

    public void save(Person person){

        person.setId(++countId);
        people.add(person);

    }

}
