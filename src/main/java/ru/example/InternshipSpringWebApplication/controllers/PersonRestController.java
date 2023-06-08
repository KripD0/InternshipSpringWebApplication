package ru.example.InternshipSpringWebApplication.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.example.InternshipSpringWebApplication.dao.PersonDAO;
import ru.example.InternshipSpringWebApplication.model.Person;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonRestController {

    private PersonDAO personDAO;

    public PersonRestController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping
    public ResponseEntity<?> getPersons(){
        return new ResponseEntity<>(personDAO.index(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createPerson(@RequestBody Person person){
        personDAO.addPerson(person);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable("id") int id, @RequestBody Person person){
        personDAO.update(id, person);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable("id") int id){
        personDAO.delete(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
