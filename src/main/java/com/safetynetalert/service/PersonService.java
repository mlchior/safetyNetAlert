package com.safetynetalert.service;

import com.safetynetalert.DTO.link2.AgeOfPersons;
import com.safetynetalert.DTO.link3.PhoneAlert;
import com.safetynetalert.model.Person;
import com.safetynetalert.repository.FirestationRepository;
import com.safetynetalert.repository.IPersonRepository;
import com.safetynetalert.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tinylog.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



@Service
public class PersonService {
    @Autowired
    private IPersonRepository iPersonRepository;
    public List<Person> findAllPerson() {
        Logger.info("findAllPerson SUCCESS");
        return iPersonRepository.getAll();
    }
    public Person addPerson(Person person) {
        Logger.info("addPerson SUCCESS" + person);
        return iPersonRepository.addPerson(person);
    }
    public Person updatePerson(Person person) {
        Logger.info("updatePerson SUCCESS" + person);
        return iPersonRepository.updatePerson(person);
    }

    public Person deletePerson(String firstName, String lastName) {
        Logger.info("deletePerson SUCCESS" + firstName + lastName);
        return iPersonRepository.deletePerson(firstName, lastName);
    }

    public List<String> getCommunityEmail(String city) {
        Logger.info("getCommunityEmail SUCCESS" + city);
        return iPersonRepository.getCommunityEmail(city);
    }

    public Collection<Object> getPersonInfo(String firstName, String lastName) {
        Logger.info("getPersonInfo SUCCESS" + firstName + lastName);
        return iPersonRepository.getPersonInfo(firstName, lastName);
    }
    /*  ---------------------------------------------------------------------------------------------------------------------*/

}

