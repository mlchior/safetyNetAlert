package com.safetynetalert.service;

import com.safetynetalert.model.Person;
import com.safetynetalert.repository.IPersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class PersonServiceTest {

    @MockBean
    private IPersonRepository ipersonRepository;

    @Autowired
    private PersonService personService;

    @Test
    void findAllPerson() {

        Person person = new Person();
        person.setFirstName("firstNameTest");
        person.setLastName("lastNameTest");
        person.setAddress("addressTest");
        person.setCity("cityTest");
        person.setZip("zipTest");
        person.setPhone("phoneTest");
        person.setEmail("emailTest");
        List<Person> personList = new ArrayList<>();
        personList.add(person);
        when(ipersonRepository.getAll()).thenReturn(personList);
        assertThat(personService.findAllPerson().toString(), containsString("firstNameTest"));
    }

    @Test
    void addPerson() {
        Person person = new Person();
        person.setFirstName("firstNameTest");
        person.setLastName("lastNameTest");
        person.setAddress("addressTest");
        person.setCity("cityTest");
        person.setZip("zipTest");
        person.setPhone("phoneTest");
        person.setEmail("emailTest");
        when(ipersonRepository.addPerson(any(Person.class))).thenReturn(person);
        assertThat(personService.addPerson(person).toString(), containsString("firstNameTest"));


    }

    @Test
    void updatePerson() {
        Person person = new Person();
        person.setFirstName("firstNameTest");
        person.setLastName("lastNameTest");
        person.setAddress("addressTest");
        person.setCity("cityTest");
        person.setZip("zipTest");
        person.setPhone("phoneTest");
        person.setEmail("emailTest");
        when(ipersonRepository.updatePerson(any(Person.class))).thenReturn(person);
        assertThat(personService.updatePerson(person).toString(), containsString("firstNameTest"));
       }

    @Test
    void deletePerson() {
        Person person = new Person();
        person.setFirstName("firstNameTest");
        person.setLastName("lastNameTest");
        person.setAddress("addressTest");
        person.setCity("cityTest");
        person.setZip("zipTest");
        person.setPhone("phoneTest");
        person.setEmail("emailTest");
        when(ipersonRepository.deletePerson(any(String.class),(any(String.class)))).thenReturn(person);
        assertThat(personService.deletePerson("firstNameTest", "lastNameTest").toString(), containsString("firstNameTest"));

    }
    @Test
    void findPersonByAddress() {
        Person person = new Person();
        person.setFirstName("firstNameTest");
        person.setLastName("lastNameTest");
        person.setAddress("addressTest");
        person.setCity("cityTest");
        person.setZip("zipTest");
        person.setPhone("phoneTest");
        person.setEmail("emailTest");
        List<Person> personList = new ArrayList<>();
        personList.add(person);
        when(ipersonRepository.getPersonsByAddress(any(String.class))).thenReturn(personList);
        assertThat(personService.getPersonsByAddress("addressTest").toString(), containsString("firstNameTest"));
    }

}