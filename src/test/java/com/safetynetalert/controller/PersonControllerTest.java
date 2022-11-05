package com.safetynetalert.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynetalert.model.Database;
import com.safetynetalert.model.Person;
import com.safetynetalert.service.PersonService;
import org.junit.Ignore;
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
import java.util.Collections;
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
        person = new Person("John", "Doe", "22 rue la clef des champs", "Saint Ouen", "93400", "0634432234", "boulou@gmail.com");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);

        when(personServiceMock.addPerson(person)).thenReturn(person);
        System.out.println(json);
        mvc.perform(MockMvcRequestBuilders.post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("John"));
    }

    @Test
    void updatePerson() throws Exception {
        Person person = new Person("John", "Doe", "22 rue la clef des champs", "Les puces", "93400", "0634432234", "boulou@gmail.com");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);
        when(personServiceMock.updatePerson(person)).thenReturn(person);
        mvc.perform(MockMvcRequestBuilders.put("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andDo(print())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.city").value("Les puces"));
    }
 @Test

    void deletePerson() throws Exception {
        Person person = new Person("John", "Doe", "22 rue la clef des champs", "Les puces", "93400", "0634432234", "boulou@gmail.com");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);
        when(personServiceMock.deletePerson(person.getFirstName(), person.getLastName())).thenReturn(person);
        mvc.perform(MockMvcRequestBuilders.delete("/person?firstName=John&lastName=Doe")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.city").value("Les puces"));
    }


    @Test
    void getCommunityEmail() throws Exception {
        Person person = new Person("John", "Doe", "22 rue la clef des champs", "puces", "93400", "0634432234", "boulou@gmail.com");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person.getCity());
        when(personServiceMock.getCommunityEmail("puces")).thenReturn(Collections.singletonList(person.getEmail()));
        mvc.perform(MockMvcRequestBuilders.get("/communityEmail?city=puces")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]").value("boulou@gmail.com"));


    }



   /* @Test
    @Ignore
    void getPersonsByAddress() throws Exception {
        Person person = new Person("John", "Doe", "22 rue la clef des champs", "puces", "93400", "0634432234", "boulou@gmail.com");
        when(personServiceMock.getPersonsByAddress("22 rue la clef des champs")).thenReturn(Collections.singletonList(person));
        mvc.perform(MockMvcRequestBuilders.get("/personByAddress?")
                        .param("address", "22 rue la clef des champs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

    }*/
}


