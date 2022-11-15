package com.safetynetalert.repository;

import com.safetynetalert.model.Database;
import com.safetynetalert.model.Firestation;
import com.safetynetalert.model.Person;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FirestationRepositoryTest {



    @Autowired
    Database db;

    @Test
    void getAll() {
        List<Firestation> firestation = new ArrayList<>();
        firestation.add(new Firestation("addressTest", 1));
        FirestationRepository firestationRepository = new FirestationRepository();
        when(db.getFirestations()).thenReturn(firestation);
        assertEquals(firestation ,firestationRepository.getAll());

    }

    @Test
    void addFirestation() {
    }

    @Test
    void updateFirestation() {
    }

    @Test
    void deleteFirestation() {
    }

    @Test
    void getFirestationByAdress() {
    }

    @Test
    void getFirestationByStation() {
    }

    @Test
    void findAllFirestationByStation() {
    }

    @Test
    void findFirestationByAdress() {
    }

    @Test
    void findAllAddressByStation() {
    }

    @Test
    void getStationInfo() {
    }
}