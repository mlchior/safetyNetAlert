package com.safetynetalert.service;

import com.safetynetalert.DTO.link2.AgeOfPersons;
import com.safetynetalert.DTO.link3.PhoneAlert;
import com.safetynetalert.model.Person;
import com.safetynetalert.repository.FirestationRepository;
import com.safetynetalert.repository.IPersonRepository;
import com.safetynetalert.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class PersonService {
    private static final Logger logger = LogManager.getLogger("PersonService");
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private FirestationRepository firestationRepository;
    @Autowired
    private IPersonRepository iPersonRepository;

    public List<Person> findAllPerson() {
        return iPersonRepository.getAll();
    }

    public Person addPerson(Person person) {
        return personRepository.add(person);
    }

    public Person deletePerson(String firstName, String lastName) {
        return personRepository.deletePerson(firstName, lastName);
    }
    public Person findMedicalRecord(String firstName, String lastName) {
        return personRepository.findMedicalRecord(firstName, lastName);
    }

    //TODO Recuperer tous les emails des habitants d'une ville
    public List<String> findAllEmailsByCity(String city) {
        return personRepository.getAllEmailsByCity(city);
    }


    public Person updatePerson(Person person) {
        return personRepository.update(person);
    }

    public List<String> findPersonByFirestation(String station) {
        return personRepository.getAllPersonByCity(station);
    }


    public Person getPersonInfo(String firstName, String lastName) {
        return personRepository.getPersonInfo(firstName, lastName);
    }

    public List<String> getAllEmailByCity(String city) {
        return personRepository.getAllEmailByCity(city);
    }

    public Person getByFirstNameAndLastName(String firstName, String lastName) {
        return personRepository.getByFirstNameAndLastName(firstName, lastName);
    }


    //je donner en paramettre le nom et prenom de la personne
    //je creer une nouvelle list personsInfoList
    // si firstName et lastName de personsList == firstName et lastName de medicalRecord
    // alors ajouter les informations de la personne ("name","adress","age","email","medication","allergie") dans personsInfoList et retourner la liste
    // sinon retourner une liste vide

    //Return a list of phone by station
  /*  public List<PhoneAlert> findPhoneByStation(String station) {
        List<Person> personsList = new ArrayList<>();
        List<PhoneAlert> phoneAlertList = new ArrayList<>();



    }**/
    //
    //getAllpersonsByadress
    public List<String> getAllpersonsByadress(String adress) {
        List<String> persons = new ArrayList<>();
        for (Person person : personRepository.getAll()) {
            if (person.getAddress().toLowerCase().equals(adress.toLowerCase())) {
                persons.add(person.getFirstName() + " " + person.getLastName() + " " + person.getAddress()+" "+person.getPhone());
            }
        }
        return persons;
    }



}

