package com.safetynetalert.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynetalert.model.Database;
import com.safetynetalert.model.Firestation;
import com.safetynetalert.service.FirestationService;
import com.safetynetalert.service.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import javax.xml.crypto.Data;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class FirestationControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    Database db;

    @MockBean
    @Autowired
    private FirestationService firestationServiceMock;


    @Test
    public void getAllFirestation() throws Exception {
        List<Firestation> firestation = new ArrayList<>();
        firestation.add(new Firestation("addressTest", 1));
        when(firestationServiceMock.findAllFirestation()).thenReturn(firestation);
        mvc.perform(MockMvcRequestBuilders.get("/firestation")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].address").value("addressTest"));

    }

    @Test
    void addFirestation() throws Exception {
        Firestation firestation = new Firestation();
        firestation = new Firestation("addressTest", 1);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(firestation);

        when(firestationServiceMock.addFirestation(firestation)).thenReturn(firestation);
        mvc.perform(MockMvcRequestBuilders.post("/firestation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.address").value("addressTest"));
    }

    @Test
    void updateFirestation() throws Exception {
        Firestation firestation = new Firestation("addressTest", 1);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(firestation);
        when(firestationServiceMock.updateFirestation(firestation)).thenReturn(firestation);
        mvc.perform(MockMvcRequestBuilders.put("/firestation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.address").value("addressTest"));
    }

    @Test
    void deleteFirestation() throws Exception {
        Firestation firestation = new Firestation("addressTest", 1);
        when(firestationServiceMock.deleteFirestation(firestation.getAddress())).thenReturn(firestation);
        mvc.perform(MockMvcRequestBuilders.delete("/firestation?address=addressTest")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.address").value("addressTest"));
    }

    @Test
    void findFirestationByAdress() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/firestationbyadress?address=1509 Culver St")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    void findFirestationByAdress2() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/firestationbyadress?adress=2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }


    @Test
    void stationList() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/stationList?station=2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    void stationList2() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/stationList?station=String")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

}