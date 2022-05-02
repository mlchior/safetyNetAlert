package com.safetynetalert.repository;

import com.safetynetalert.model.Firestation;
import com.safetynetalert.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {
    private static ArrayList<Person> personsList = new ArrayList<>();

    public static void initPersonList() {
        personsList.add(new Person("John", "Doe", "clef des champs", "Melbourne", "55555", "0634437847636", "boulou@gmail.com"));
        personsList.add(new Person("John", "Smith", "123 Main St.", "montrouge", "93400", "0634432234", "bilou@gmail.com"));
        personsList.add(new Person("andré", "tutu", "clef des champs", "paris", "75017", "0634437847636", "andre.tutu@gmail.com"));

    }

    //trouver toutes les personnes
    public static ArrayList<Person> getAll() {
        return personsList;
    }
// trouver une personne par son nom

    public Person getByFirstNameAndLastName(String firstName, String lastName) {
        for (Person person : personsList) {
            if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
                return person;
            }
        }
        return null;
    }

    public Person getByZip(String zip) {
        for (int i = 0; i < personsList.size(); i++) {
            if (personsList.get(i).getZip().equals(zip)) {
                return personsList.get(i);
            }
        }
        return null;
    }
}

