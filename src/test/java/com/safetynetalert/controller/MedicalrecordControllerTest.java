package com.safetynetalert.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynetalert.model.Database;
import com.safetynetalert.model.Medicalrecord;
import com.safetynetalert.service.MedicalRecordService;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MedicalrecordControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    Database db;

    @MockBean
    @Autowired
    private MedicalRecordService medicalRecordServiceMock;

    @Test
    void getAllMedicalrecord() throws Exception {
        List<Medicalrecord> medicalrecord = new ArrayList<>();
        medicalrecord.add(new Medicalrecord("firstNameTest", "lastNameTest", "01/01/2000", List.of(new String[]{"medicationTest"}), List.of(new String[]{"allergyTest"})));
        when( medicalRecordServiceMock.findAllMedicalrecord()).thenReturn(medicalrecord);
        mvc.perform(MockMvcRequestBuilders.get("/medicalrecord")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName").value("firstNameTest"));
    }

    @Test
    void addMedicalRecord() throws Exception {
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord = new Medicalrecord("firstNameTest", "lastNameTest", "01/01/2000", List.of(new String[]{"medicationTest"}), List.of(new String[]{"allergyTest"}));
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(medicalrecord);
        when(medicalRecordServiceMock.addMedicalRecord(medicalrecord)).thenReturn(medicalrecord);
        mvc.perform(MockMvcRequestBuilders.post("/medicalrecord")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("firstNameTest"));
    }

    @Test
    void updateMedicalRecord() throws Exception {
        Medicalrecord medicalrecord = new Medicalrecord("firstNameTest", "lastNameTest", "01/01/2000", List.of(new String[]{"medicationTest"}), List.of(new String[]{"allergyTest"}));
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(medicalrecord);
        when( medicalRecordServiceMock.updateMedicalRecord(medicalrecord)).thenReturn(medicalrecord);
        mvc.perform(MockMvcRequestBuilders.put("/medicalrecord")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("firstNameTest"));
    }

    @Test
    void deleteMedicalRecord() throws Exception {
        Medicalrecord medicalrecord = new Medicalrecord("firstNameTest", "lastNameTest", "01/01/2000", List.of(new String[]{"medicationTest"}), List.of(new String[]{"allergyTest"}));
        when( medicalRecordServiceMock.deleteMedicalRecord(medicalrecord.getFirstName(),medicalrecord.getLastName())).thenReturn(medicalrecord);
        mvc.perform(MockMvcRequestBuilders.delete("/medicalrecord?firstName=firstNameTest&lastName=lastNameTest")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("firstNameTest"));
    }
}