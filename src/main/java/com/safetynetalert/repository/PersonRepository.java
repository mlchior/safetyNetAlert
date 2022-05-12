package com.safetynetalert.repository;

import com.safetynetalert.model.Firestation;
import com.safetynetalert.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository
public class PersonRepository {
    private static ArrayList<Person> personsList = new ArrayList<>();

    public static void initPersonList() {
        personsList.add(new Person("John", "Doe", "clef des champs", "Melbourne", "55555", "0634437847636", "boulou@gmail.com"));
        personsList.add(new Person("John", "Smith", "123 Main St.", "montrouge", "93400", "0634432234", "bilou@gmail.com"));
        personsList.add(new Person("andré", "tutu", "clef des champs", "paris", "75017", "0634437847636", "andre.tutu@gmail.com"));
        personsList.add(new Person("Yacine", "PE", "21 jump street", "Melbourne","55555", "0134567899","yacine@pole-emploi.fr"));
        personsList.add(new Person("Laurence", "PE", "21 jump street", "Melbourne","55555", "0134567899","laurence@pe.fr"));
    }

    //trouver toutes les personnes
    public static ArrayList<Person> getAll() {
        return personsList;
    }
// trouver une personne par son nom

    public Person getByFirstNameAndLastName(String firstName, String lastName) {
        for (Person person : personsList) {
            if (person.getFirstName().toLowerCase().equals(firstName.toLowerCase()) && person.getLastName().toLowerCase().equals(lastName.toLowerCase())) {
                return person;
            }
        }
        return null;
    }

    public static Person getByZip(String zip) {
        for (int i = 0; i < personsList.size(); i++) {
            if (personsList.get(i).getZip().equals(zip)) {
                return personsList.get(i);
            }
        }
        return null;
    }

    public static Person getByCity(String city) {
        for (int i = 0; i < personsList.size(); i++) {
            if (personsList.get(i).getCity().equals(city)) {
                return personsList.get(i);
            }
        }
        return null;
    }
    //get all persons by zip

    public List<String> getAllPersonByCity(String city) {
        List<String> persons = new ArrayList<>();
        for (Person person : personsList) {
            if (person.getCity().equals(city)) {
                persons.add(person.getFirstName() + " " + person.getLastName() + " " + person.getAddress()+" "+person.getPhone());
            }
        }
            return persons;
    }

    public List<String> getAllEmailsByCity(String city) {
        List<String> emails = new ArrayList<>();
        for (Person person : personsList) {
            if (person.getCity().equals(city)) {
                emails.add(person.getEmail());
            }
        }
        return emails;
    }


    public Person add(Person person) {
        personsList.add(person);
        System.out.println(person.getFirstName());
        return person;

    }

    public Person delete(Person person) {
        personsList.remove(person);
        System.out.println(personsList);
        return person;
    }

    public Person delete(String firstName, String lastName) {
        Person person = getByFirstNameAndLastName(firstName, lastName);
        return person;

    }




    }






