package ru.example.InternshipSpringWebApplication.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.example.InternshipSpringWebApplication.dao.PersonDAO;
import ru.example.InternshipSpringWebApplication.model.Person;

@RestController
@RequestMapping("/person")
public class PersonRestController {

    //Пробовал поставить на все методы аннотацию @ResponseStatus, спросить как возвращать json, если в ResponseEntity нет перегруженного метода только с телом ответа.

    private PersonDAO personDAO;

    public PersonRestController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping
    public ResponseEntity<?> getPersons(){
        return ResponseEntity.ok(personDAO.index());
    }

    @PostMapping
    public ResponseEntity<?> createPerson(@RequestBody Person person){
        return ResponseEntity.ok(personDAO.addPerson(person));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable("id") int id, @RequestBody Person person){
        return ResponseEntity.ok(personDAO.update(id, person));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable("id") int id){
        personDAO.delete(id);
    }
}
