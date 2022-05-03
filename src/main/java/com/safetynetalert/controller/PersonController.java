package com.safetynetalert.controller;

import com.safetynetalert.model.Person;
import com.safetynetalert.service.PersonService;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/person/all")
    public List<Person> getAllPerson(){
        return personService.findAllPerson();
    }

    @GetMapping("/person/{firstName}/{lastName}")
    public Person getByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName){
        return personService.findPersonByFirstNameAndLastName(firstName, lastName);
    }

   @GetMapping("/person/{zip}")
    public Person getByZip(@PathVariable String zip){
        return personService.findPersonByZip(zip);
    }

   @GetMapping("/person/{city}")
    public Person getByCity(@PathVariable String city){
        return personService.findPersonByCity(city);
    }

    //TODO Recuperer tous les emails des habitants d'une ville
    @GetMapping("/person/{city}/email")
    public List<String> getEmailByCity(@PathVariable String city){
        return personService.findAllEmailsByCity(city);
    }

}

