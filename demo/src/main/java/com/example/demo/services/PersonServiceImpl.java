package com.example.demo.services;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.mocks.Person;
import com.example.demo.repositories.PersonRepo;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private PersonRepo personRepo;

    @Override
    public Person createPerson(Person person) {
        return personRepo.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        Optional<Person> personOpt = this.personRepo.findById(person.getId());
        if (personOpt.isPresent()) {
            Person updatedPerson = personOpt.get();
            updatedPerson.setName(person.getName());
            updatedPerson.setAge(person.getAge());
            updatedPerson.setBio(person.getBio());
            personRepo.save(updatedPerson);
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + person.getId());
        }
        return null;
    }

    @Override
    public Iterable<Person> getAllPeople() {
        return personRepo.findAll();
    }

    @Override
    public Person getPersonById(long id) {
        Optional<Person> optional = personRepo.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            // throw error
            return null;
        }
    }

    @Override
    public void deletePerson(long id) {
        Person person = getPersonById(id);
        personRepo.delete(person);
    }
}
