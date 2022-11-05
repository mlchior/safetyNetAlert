package com.safetynetalert.service;

import com.safetynetalert.model.Firestation;
import com.safetynetalert.repository.IFirestationRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class FirestationServiceTest {



    @MockBean
    private IFirestationRepository ifirestationRepository;

    @Autowired
    private FirestationService firestationService;

    @Test
    public void getAllFirestations() {
        Firestation firestation = new Firestation();
        firestation.setStation(1);
        firestation.setAddress("addressTest");
        List<Firestation> firestationList = new ArrayList<>();
        firestationList.add(firestation);
        when(ifirestationRepository.getAll()).thenReturn(firestationList);
        assertThat(firestationService.findAllFirestation().toString(), containsString("addressTest"));
    }


    @Test
    void addFirestation() {
        Firestation firestation = new Firestation();
        firestation.setStation(1);
        firestation.setAddress("addressTest");
        when(ifirestationRepository.addFirestation(any(Firestation.class))).thenReturn(firestation);
        assertThat(firestationService.addFirestation(firestation).toString(), containsString("addressTest"));
    }

    @Test
    void updateFirestation() {
        Firestation firestation = new Firestation();
        firestation.setStation(1);
        firestation.setAddress("addressTest");
        when(ifirestationRepository.updateFirestation(any(Firestation.class))).thenReturn(firestation);
        assertThat(firestationService.updateFirestation(firestation).toString(), containsString("addressTest"));
    }

    @Test
    void deleteFirestation() {
        Firestation firestation = new Firestation();
        firestation.setStation(1);
        firestation.setAddress("addressTest");
        when(ifirestationRepository.deleteFirestation(any(String.class))).thenReturn(firestation);
        assertThat(firestationService.deleteFirestation("addressTest").toString(), containsString("addressTest"));
    }


}