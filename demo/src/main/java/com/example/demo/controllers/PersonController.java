package com.example.demo.controllers;

import com.example.demo.mocks.Person;
import com.example.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    @Autowired
    public PersonService personService;

    @GetMapping("/persons")
    public ResponseEntity<Iterable<Person>> getAllPeople() {
        return ResponseEntity.ok().body(personService.getAllPeople());
    }

    @GetMapping("/persons/[id]")
    public ResponseEntity<Person> getPerson(@PathVariable long id) {
        return ResponseEntity.ok().body(personService.getPersonById(id));
    }


    @PostMapping("/person")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return ResponseEntity.ok().body(personService.createPerson(person));
    }

    @PutMapping("persons/[id]")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person person) {
        person.setId(id);
        return ResponseEntity.ok().body(this.personService.updatePerson(person));
    }

    @DeleteMapping("/products/[id]")
    public HttpStatus deletePerson(@PathVariable long id) {
        this.personService.deletePerson(id);
        return HttpStatus.OK;
    }
}





















