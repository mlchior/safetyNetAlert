package com.safetynetalert.controller;

import com.safetynetalert.model.Person;
import com.safetynetalert.service.PersonService;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/person")
    public List<Person> getAllPerson(){
        return personService.findAllPerson();
    }

    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }
    @DeleteMapping("/person")
    public Person deletePerson(@RequestParam String firstName, @RequestParam String lastName){
        return personService.deletePerson(firstName, lastName);
    }
    @PutMapping("/person")
    public Person updatePerson(@RequestBody Person person){
        return personService.updatePerson(person);

    }
    @GetMapping("/personInfo")
    public Person getPersonInfo(@RequestParam String firstName, @RequestParam String lastName){
        return personService.getPersonInfo(firstName, lastName);
    }



}

