package ru.example.InternshipSpringWebApplication.dao;

import org.springframework.stereotype.Component;
import ru.example.InternshipSpringWebApplication.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PERSON_COUNT;

    private static List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PERSON_COUNT,"Tom", 15, "test@mail.ru"));
        people.add(new Person(++PERSON_COUNT,"Ana", 17, "test@mail.ru"));
        people.add(new Person(++PERSON_COUNT,"Hank", 12, "test@mail.ru"));
        people.add(new Person(++PERSON_COUNT,"Pim", 18, "test@mail.ru"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void addPerson(Person person){
        person.setId(++PERSON_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson){
        Person person = show(id);

        person.setAge(updatedPerson.getAge());
        person.setName(updatedPerson.getName());
        person.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id){
        people.removeIf(person -> person.getId() == id);
    }

}
