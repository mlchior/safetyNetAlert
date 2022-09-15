package com.safetynetalert.controller;

import com.safetynetalert.model.Person;
import com.safetynetalert.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tinylog.Logger;

import java.util.Collection;
import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/person")
    public List<Person> getAllPerson() {
        List<Person> p = personService.findAllPerson();
        if (p.isEmpty()) {
            Logger.error("getAllPerson FAILED");
        } else {
            Logger.info("getAllPerson SUCCESS");
        }
        return personService.findAllPerson();
    }

    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person) {
        if (personService.addPerson(person) == null) {
            Logger.error("addPerson FAILED");
        } else {
            Logger.info("addPerson SUCCESS");
        }
        return personService.addPerson(person);
    }

    @PutMapping("/person")
    public Person updatePerson(@RequestBody Person person) {
        if (personService.updatePerson(person) == null) {
            Logger.error("updatePerson FAILED");
        } else {
            Logger.info("updatePerson SUCCESS");
        }
        return personService.updatePerson(person);
    }

    @DeleteMapping("/person")
    public Person deletePerson(@RequestParam String firstName, @RequestParam String lastName) {
        if (personService.deletePerson(firstName, lastName) == null) {
            Logger.error("deletePerson FAILED");
        } else {
            Logger.info("deletePerson SUCCESS");
        }
        return personService.deletePerson(firstName, lastName);
    }

    @GetMapping("/communityEmail")
    // get all the emails by city
    public List<String> getCommunityEmail(@RequestParam String city) {
        if (personService.getCommunityEmail(city).isEmpty()) {
            Logger.error("getCommunityEmail FAILED");
        } else {
            Logger.info("getCommunityEmail SUCCESS");
        }
        return personService.getCommunityEmail(city);
    }
    @GetMapping("/personInfo")
    public Collection<Object> getPersonInfo(@RequestParam String firstName, @RequestParam String lastName) {
        if (personService.getPersonInfo(firstName, lastName).isEmpty()) {
            Logger.error("getPersonInfo FAILED");
        } else {
            Logger.info("getPersonInfo SUCCESS");
        }
        return personService.getPersonInfo(firstName, lastName);
    }
}



