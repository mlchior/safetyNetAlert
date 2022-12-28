package com.safetynetalert.controller;

import com.safetynetalert.DTO.link2.ChildAlert;
import com.safetynetalert.model.Person;
import com.safetynetalert.service.PersonService;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tinylog.Logger;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/person")
    public List<Person> getAllPerson() {
        List<Person> findAllPerson = personService.findAllPerson();
        if (findAllPerson.isEmpty()) {
            Logger.error("getAllPerson FAILED");
        } else {
            Logger.info("getAllPerson SUCCESS");
        }
        return findAllPerson;
    }

    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person) {
        Person addPerson = personService.addPerson(person);
        if (addPerson == null) {
            Logger.error("addPerson FAILED");
        } else {
            Logger.info("addPerson SUCCESS");
        }
        return addPerson;
    }

    @PutMapping("/person")
    public Person updatePerson(@RequestBody Person person) {
        Person updatePerson = personService.updatePerson(person);
        if (updatePerson == null) {
            Logger.error("updatePerson FAILED");
        } else {
            Logger.info("updatePerson SUCCESS");
        }
        return updatePerson;
    }

    @DeleteMapping("/person")
    public Person deletePerson(@RequestParam String firstName, @RequestParam String lastName) {
        Person deletePerson = personService.deletePerson(firstName, lastName);
        if (deletePerson == null) {
            Logger.error("deletePerson FAILED");
        } else {
            Logger.info("deletePerson SUCCESS");
        }
        return deletePerson;
    }



    @GetMapping("/personsByAddress")
    public List<Person> getPersonsByAddress(@RequestParam String address) {
        List<Person> getpersonsByAddress = personService.getPersonsByAddress(address);
        if (getpersonsByAddress == null) {
            Logger.error("getPersonsBchatgpyAddress FAILED");
        } else {
            Logger.info("getPersonsByAddress SUCCESS");
        }
        return getpersonsByAddress;
    }

}



