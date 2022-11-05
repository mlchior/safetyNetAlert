package com.safetynetalert.controller;

import com.safetynetalert.service.EndPointService;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class EnpointControlerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    EndPointService endPointService;



    @Test
    public void findStationInfo() throws Exception {
            mvc.perform(get("/firestation/stationNumberz?station=1"))
                    .andExpect(status().isOk());
        }
    @Test
    public void getChildAlert() throws Exception {
        mvc.perform(get("/childAlert?address=1509 Culver St"))
                .andExpect(status().isOk());
    }
    @Ignore
    @Test void PhoneAlert() throws Exception {
        mvc.perform(get("/phoneAlert?station=1"))
                .andExpect(status().isOk());
    }
    @Ignore
    @Test
    public void getCommunityEmail() throws Exception {
        mvc.perform(get("/communityEmail?city=Culver"))
                .andExpect(status().isOk());
    }
    @Ignore
    @Test
    public void getPersonInfo() throws Exception {
        mvc.perform(get("/personInfo?firstName=John&lastName=Boyd"))
                .andExpect(status().isOk());
    }
    @Ignore
    @Test
    public void getFlood() throws Exception {
        mvc.perform(get("/flood/stations?stations=1"))
                .andExpect(status().isOk());
    }

    @Test
    public void getFire() throws Exception {
        mvc.perform(get("/fire?address=1509 Culver St"))
                .andExpect(status().isOk());
    }

}