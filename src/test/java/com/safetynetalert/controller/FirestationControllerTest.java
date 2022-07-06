package com.safetynetalert.controller;

import com.safetynetalert.model.Firestation;
import com.safetynetalert.service.FirestationService;
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

import static org.hamcrest.Matchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FirestationControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private FirestationService firestationServiceMock;

    @Test
    public void testGetAllFirestation() throws Exception {
        List<Firestation> firestation = new ArrayList<>();
        firestation.add(new Firestation("salut",3));
        when(firestationServiceMock.findAllFirestation()).thenReturn(firestation);
mvc.perform(MockMvcRequestBuilders.get("/firestation")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].address").value("salut"));


    }
    @Test
    public void testAddFirestation() throws Exception {
        Firestation firestation = new Firestation("salut",3);
        when(firestationServiceMock.addFirestation(firestation)).thenReturn(firestation);
        mvc.perform(MockMvcRequestBuilders.post("/firestation")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"address\":\"salut\",\"station\":3}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.address").value("salut"));

    }
    @Test
    public void testUpdateFirestation() throws Exception {
        Firestation firestation = new Firestation("salut",3);
        when(firestationServiceMock.updateFirestation(firestation)).thenReturn(firestation);
        mvc.perform(MockMvcRequestBuilders.put("/firestation")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"address\":\"salut\",\"station\":3}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.address").value("salut"));

    }

   }


