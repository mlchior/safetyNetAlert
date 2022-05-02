package com.safetynetalert.service;

import com.safetynetalert.model.Person;
import com.safetynetalert.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;



    public List<Person> findAllPerson() {
        return personRepository.getAll();
    }
    public Person findPersonByFirstNameAndLastName(String firstName, String lastName) {
        return personRepository.getByFirstNameAndLastName(firstName, lastName);
    }

    public Person findPersonByZip(String zip) {
        return personRepository.getByZip(zip);
    }
    }

