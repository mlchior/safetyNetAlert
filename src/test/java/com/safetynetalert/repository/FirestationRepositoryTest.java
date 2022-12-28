package com.safetynetalert.repository;

import com.safetynetalert.model.Database;
import com.safetynetalert.model.Firestation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class FirestationRepositoryTest {
    Database database = new Database();
    FirestationRepository firestationRepository;

    @BeforeEach
    void setUp() {
        List<Firestation> firestations = new ArrayList<>();
        Firestation firestation = new Firestation();
        firestation.setAddress("address");
        firestation.setStation(1);
        firestations.add(firestation);
        Database.setFirestations(firestations);
        firestationRepository = new FirestationRepository(database);
    }

    @Test
    public void getAll() {
        Assertions.assertEquals(1, firestationRepository.getAll().size());
    }

    @Test
    public void addFirestation(){
        Assertions.assertNotNull( firestationRepository.addFirestation(new Firestation()));
    }

    @Test
    public void updateFirestation(){
        Firestation firestation = new Firestation();
        firestation.setAddress("address");
        Assertions.assertNotNull( firestationRepository.updateFirestation(firestation));
    }

    @Test
    public void deleteFirestation(){
        Assertions.assertNotNull( firestationRepository.deleteFirestation("address"));
    }

    @Test
    public void getFirestationByAdress(){
        Assertions.assertNotNull( firestationRepository.getFirestationByAdress("address"));
    }

    @Test
    public void getFirestationByStation(){
        Assertions.assertNotNull( firestationRepository.getFirestationByStation(1));
    }

    @Test
    public void findFirestationByAdress(){
        Assertions.assertNotNull( firestationRepository.findFirestationByAdress("address").get(0));
    }

    @Test
    public void findAllAddressByStation(){
        Assertions.assertNotNull( firestationRepository.findAllAddressByStation(1).get(0));
    }

    @Test
    public void getStationInfo1(){
        Assertions.assertNotNull( firestationRepository.getStationInfo(1).get(0));
    }

    @Test
    //DisplayName("test getStationInfo when station is diffrent form firestation station value")
    public void getStationInfo2(){
        Assertions.assertNull( firestationRepository.getStationInfo(2));
    }

    @Test
    public void findAllFirestationByStation(){
        Assertions.assertNotNull( firestationRepository.findAllFirestationByStation(1).get(0));
    }

}