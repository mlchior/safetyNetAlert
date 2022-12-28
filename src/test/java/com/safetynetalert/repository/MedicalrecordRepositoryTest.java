package com.safetynetalert.repository;

import com.safetynetalert.model.Database;
import com.safetynetalert.model.Medicalrecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MedicalrecordRepositoryTest {

    Database database = new Database();
    MedicalrecordRepository medicalrecordRepository;

    @BeforeEach
    void setUp() {
        List<Medicalrecord> medicalrecords = new ArrayList<>();
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord.setFirstName("firstName");
        medicalrecord.setLastName("lastName");
        medicalrecord.setBirthdate("birthdate");
        medicalrecord.setMedications(List.of("medications"));
        medicalrecord.setAllergies(List.of("allergies"));
        medicalrecords.add(medicalrecord);
        Database.setMedicalrecords(medicalrecords);
        medicalrecordRepository = new MedicalrecordRepository(database);


    }

    @Test
    public void getAll() {
        Assertions.assertEquals(1, medicalrecordRepository.getAll().size());
    }

    @Test
    void addMedicalRecord() {
        Assertions.assertNotNull(medicalrecordRepository.addMedicalRecord(new Medicalrecord()));
    }

    @Test
    void updateMedicalRecord() {
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord.setFirstName("firstName");
        medicalrecord.setLastName("lastName");
        medicalrecord.setBirthdate("newBirthdate");
        medicalrecord.setMedications(List.of("medications"));
        medicalrecord.setAllergies(List.of("allergies"));
        Assertions.assertNotNull(medicalrecordRepository.updateMedicalRecord(medicalrecord));

    }

    @Test
    void deleteMedicalRecord() {
        Assertions.assertNotNull(medicalrecordRepository.deleteMedicalRecord("firstName", "lastName"));
    }

    @Test
    public void getMedicalrecord() {
        Assertions.assertNotNull(medicalrecordRepository.getMedicalrecord("firstName", "lastName"));
    }
    @Test
    public void getMedicalrecordNull() {
        Assertions.assertNull(medicalrecordRepository.getMedicalrecord("firstName", "lastName2"));
    }

}