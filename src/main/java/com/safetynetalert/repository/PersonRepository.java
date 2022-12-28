package com.safetynetalert.repository;

import com.safetynetalert.model.Person;
import org.springframework.stereotype.Repository;
import com.safetynetalert.model.Database;

import java.util.ArrayList;
import java.util.List;




@Repository
public class PersonRepository implements IPersonRepository{
    static List<Person> persons;

    public PersonRepository(Database database){
        persons = database.getPersons();
    }


    @Override
    public List<Person> getAll() {
        return persons;
    }
    @Override
    public Person addPerson(Person person) {
        persons.add(person);
        return person;
    }

    @Override
    public Person updatePerson(Person person) {
        Person personToUpdate = getByFirstNameAndLastName(person.getFirstName(), person.getLastName());
        if(personToUpdate != null) {
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

    @Override
    public Person  deletePerson(String firstName, String lastName) {
        Person person = getByFirstNameAndLastName(firstName, lastName);
        if (person != null) {
            persons.remove(person);
        }
        return person;
    }
    @Override
    public Person getByFirstNameAndLastName(String firstName, String lastName) {
        for (Person person : persons) {
            if (person.getFirstName().equalsIgnoreCase(firstName) && person.getLastName().equalsIgnoreCase(lastName)) {
                return person;
            }
        }
        return null;
    }


    @Override
    public List<Person> getPersonsByAddress(String address) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getAddress().equalsIgnoreCase(address)) {
                result.add(person);
            }
        }
        return result;
    }
}










