package com.safetynetalert.repository;

import com.safetynetalert.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.safetynetalert.model.Database;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository implements IPersonRepository{
    private static ArrayList<Person> personsList = new ArrayList<>();
    private List<Person> persons;
    @Autowired
    private Database database;
    // add persons List of Database in the ArrayList

    @Override
    public  List<Person> getAll() {
        return database.getPersons();
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
    public List <Person>  getByAdress(String adress) {
        List<Person> persons = new ArrayList<>();
        for (Person person : personsList) {
            if (person.getAddress().toLowerCase().equals(adress.toLowerCase())) {
                persons.add(person);
            }

        }
        return persons;
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


    public Person deletePerson(String firstName, String lastName) {
        Person person = getByFirstNameAndLastName(firstName, lastName);
        if (person != null) {
            personsList.remove(person);

        }
        return person;
    }

    public Person update(Person person) {
        Person personToUpdate = getByFirstNameAndLastName(person.getFirstName(), person.getLastName());
        if (personToUpdate != null) {
            personToUpdate.setFirstName(person.getFirstName());
            personToUpdate.setLastName(person.getLastName());
            personToUpdate.setAddress(person.getAddress());
            personToUpdate.setCity(person.getCity());
            personToUpdate.setZip(person.getZip());
            personToUpdate.setPhone(person.getPhone());
            personToUpdate.setEmail(person.getEmail());
        }
        return personToUpdate;
    }

    public List<String> getAllEmailByCity(String city) {
        List<String> emails = new ArrayList<>();
        for (Person person : personsList) {
            if (person.getCity().equals(city)) {
                emails.add(person.getEmail());
            }
        }
        return emails;
    }


    public Person getPersonInfo(String firstName, String lastName) {
        Person person = getByFirstNameAndLastName(firstName, lastName);
        if (person != null) {
            return person;
        }
        return null;
    }


    public Person findMedicalRecord(String firstName, String lastName) {
        Person person = getByFirstNameAndLastName(firstName, lastName);
        if (person != null) {
            return person;
        }
        return null;
    }


    }








