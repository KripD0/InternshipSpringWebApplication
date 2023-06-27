package com.example.springyaml.service;

import com.example.springyaml.entity.Person;
import com.example.springyaml.repository.PersonRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostConstruct
    public void findAll(){
        List<Person> people = personRepository.findAll();
        people.stream().map(Person::getFullName).forEach(System.out::println);
    }
}
