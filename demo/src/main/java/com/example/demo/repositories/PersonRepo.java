package com.example.demo.repositories;

import com.example.demo.mocks.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepo extends CrudRepository<Person, Long> {
}
