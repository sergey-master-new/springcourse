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
        people.add(new Person(++countId, "Tom", 24, "tom@mail.ru"));
        people.add(new Person(++countId, "Bob", 32, "bob@mail.ru"));
        people.add(new Person(++countId, "Mike", 18, "mike@yahoo.com"));
        people.add(new Person(++countId, "Vasya", 34, "vasya@gmail.com"));
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

    public void update(int id, Person updatedPerson) {

        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {

        people.removeIf(person -> person.getId() == id);
    }
}
