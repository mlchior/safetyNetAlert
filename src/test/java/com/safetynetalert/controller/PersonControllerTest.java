package com.safetynetalert.controller;

import com.safetynetalert.model.Database;
import com.safetynetalert.model.Person;
import com.safetynetalert.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    Database db;

    @MockBean
    @Autowired
    private PersonService personServiceMock;


    @Test
    public void getAllPerson() throws Exception {
        List<Person> person = new ArrayList<>();
        person.add(new Person("John", "Doe", "22 rue la clef des champs", "Saint Ouen", "93400", "0634432234", "boulou@gmail.com"));
        when(personServiceMock.findAllPerson()).thenReturn(person);
        mvc.perform(MockMvcRequestBuilders.get("/person")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].address").value("22 rue la clef des champs"));

    }




    @Test
    void addPerson() throws Exception {
        Person person = new Person();
        when(personServiceMock.addPerson(person)).thenReturn(person);
        mvc.perform(MockMvcRequestBuilders.post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstName\":\"John\",\"lastName\":\"Doe\",\"address\":\"22 rue la clef des champs\",\"city\":\"Saint Ouen\",\"zip\":\"93400\",\"phone\":\"0634432234\",\"email\":boulou@gmail.com\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("John"));
    }

    @Test
    void updatePerson() throws Exception {
        Person person = new Person("John", "Doe", "22 rue la clef des champs", "Saint Ouen", "93400", "0634432234", "boulou@gmail.com");
        when(personServiceMock.updatePerson(person)).thenReturn(person);
        mvc.perform(MockMvcRequestBuilders.put("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstName\":\"John\",\"lastName\":\"Doe\",\"address\":\"22 rue la clef des champs\",\"city\":\"Les puces\",\"zip\":\"93400\",\"phone\":\"0634432234\",\"email\":boulou@gmail.com\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.city").value("Les puces"));
    }

   /** @Test
    void deletePerson() throws Exception {
        Person person = new Person("John", "Doe", "22 rue la clef des champs", "Saint Ouen", "93400", "0634432234", "boulou@gmail.com");

        String firstName = person.getFirstName();
        String lastName = person.getLastName();
        when(personServiceMock.deletePerson(firstName, lastName)).thenReturn(person);
        this.personServiceMock.perform(MockMvcRequestBuilders
                        .delete("/person/{person.getFirstName()}/{person.getLastName()}")
                        .param("firstName", firstName)
                        .param("lastName", lastName)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("John"));
    }*/
}
