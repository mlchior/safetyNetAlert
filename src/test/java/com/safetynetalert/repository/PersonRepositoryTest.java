package com.safetynetalert.repository;

import com.safetynetalert.model.Database;
import com.safetynetalert.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonRepositoryTest {

    Database database = new Database();

    PersonRepository personRepository;

    @BeforeEach
    void setUp() {
        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("zip");
        person.setPhone("phone");
        person.setEmail("email");
        personList.add(person);
        Database.setPersons(personList);
        personRepository = new PersonRepository(database);

    }
    @Test
    void getAll() {
        Assertions.assertEquals(1, personRepository.getAll().size());
    }

    @Test
    void addPerson() {
        Assertions.assertNotNull(personRepository.addPerson(new Person()));
    }

    @Test
    public void updatePerson() {
        Person person = new Person();
        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAddress("newAddress");
        person.setCity("city");
        person.setZip("zip");
        person.setPhone("phone");
        person.setEmail("email");
        Assertions.assertNotNull(personRepository.updatePerson(person));
    }

    @Test
    void deletePerson() {
        Assertions.assertNotNull(personRepository.deletePerson("firstName", "lastName"));
    }



    @Test
    void getByFirstNameAndLastName() {
        Assertions.assertNotNull(personRepository.getByFirstNameAndLastName("firstName", "lastName"));

    }

    @Test
    void getPersonsByAddress() {
        Assertions.assertEquals(1, personRepository.getPersonsByAddress("address").size());

    }
}