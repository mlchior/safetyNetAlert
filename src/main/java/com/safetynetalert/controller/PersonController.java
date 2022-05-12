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

    @GetMapping("/person/all")
    public List<Person> getAllPerson(){
        return personService.findAllPerson();
    }

    @GetMapping("/person/{firstName}/{lastName}")
    public Person getByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName){
        return personService.findPersonByFirstNameAndLastName(firstName, lastName);
    }

   @GetMapping("/person/{zip}")
    public Person getByZip(@RequestParam String zip){
        return personService.findPersonByZip(zip);
    }



  /* @GetMapping("/person")
   public Person getByCity(@RequestParam String city){
       return personService.findPersonByCity(city);
   }*/

   @GetMapping("/person")
   public List<String> getAllPersonByCity(@RequestParam String city){
       return personService.findPersonByCity(city);
   }


    //TODO Recuperer tous les emails des habitants d'une ville
    @GetMapping("/communityEmail")//http://localhost:8080/communityEmail?city=<city>
    public List<String> getEmailByCity(@RequestParam String city){
        return personService.findAllEmailsByCity(city);
    }

    //TODO add a person
    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }
//TODO creer un objet personInfo qui va contenir les info de plusieur objet
    //TODO delete a person with firstName and lastName
    @DeleteMapping("/person")
    public Person deletePerson(@RequestParam String firstName, @RequestParam String lastName){
        return personService.deletePerson(firstName, lastName);
    }

}

