package com.safetynetalert.repository;

import com.safetynetalert.model.Person;

import java.util.Collection;
import java.util.List;


public interface IPersonRepository {
    List<Person> getAll();


    Person addPerson(Person person);

    Person updatePerson(Person person);

    Person deletePerson(String firstName, String lastName);

    Collection<Object> getPersonInfo(String firstName, String lastName);

    List<Person> getPersonsByAddress(String address);


}
