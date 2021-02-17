package com.example.demo.services;

import com.example.demo.mocks.Person;

import java.util.List;

public interface PersonService {

    Person createPerson(Person person);

    Person updatePerson(Person person);

    Iterable<Person> getAllPeople();

    Person getPersonById(long id);

    void deletePerson(long id);
}
