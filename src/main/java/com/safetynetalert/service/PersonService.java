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
    public Person addPerson(Person person) {
        return personRepository.add(person);
    }
    public Person deletePerson(String firstName, String lastName) {
        return personRepository.deletePerson(firstName, lastName);
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


    //je donner en paramettre le nom et prenom de la personne
    //je creer une nouvelle list personsInfoList
    // si firstName et lastName de personsList == firstName et lastName de medicalRecord
    // alors ajouter les informations de la personne ("name","adress","age","email","medication","allergie") dans personsInfoList et retourner la liste
    // sinon retourner une liste vide

}

