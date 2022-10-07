package com.safetynetalert.service;

import com.safetynetalert.model.Medicalrecord;
import com.safetynetalert.repository.IMedicalrecordRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.containsString;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class MedicalRecordServiceTest {

    @MockBean
    private IMedicalrecordRepository iMedicalRecordRepository;

    @Autowired
    private MedicalRecordService medicalRecordService;


    @Test
    void findAllMedicalrecord() {
        Medicalrecord medicalrecord = new Medicalrecord();

        List<String> Medications = new ArrayList<>();
        Medications.add("medicationTest");
        List<String> Allergies = new ArrayList<>();
        Allergies.add("allergiesTest");
        medicalrecord.setFirstName("firstNameTest");
        medicalrecord.setLastName("lastNameTest");
        medicalrecord.setBirthdate("birthdateTest");
        medicalrecord.setMedications(Medications);
        medicalrecord.setAllergies(Allergies);
        List<Medicalrecord> medicalrecordList = new ArrayList<>();
        medicalrecordList.add(medicalrecord);
        when(iMedicalRecordRepository.getAll()).thenReturn(medicalrecordList);
        assertThat(medicalRecordService.findAllMedicalrecord().toString(), containsString("firstNameTest"));
    }

    @Test
    void addMedicalRecord() {
        Medicalrecord medicalrecord = new Medicalrecord();

        List<String> Medications = new ArrayList<>();
        Medications.add("medicationTest");
        List<String> Allergies = new ArrayList<>();
        Allergies.add("allergiesTest");
        medicalrecord.setFirstName("firstNameTest");
        medicalrecord.setLastName("lastNameTest");
        medicalrecord.setBirthdate("birthdateTest");
        medicalrecord.setMedications(Medications);
        medicalrecord.setAllergies(Allergies);
        when(iMedicalRecordRepository.addMedicalRecord(any(Medicalrecord.class))).thenReturn(medicalrecord);
        assertThat(medicalRecordService.addMedicalRecord(medicalrecord).toString(), containsString("firstNameTest"));
    }

    @Test
    void updateMedicalRecord() {
        Medicalrecord medicalrecord = new Medicalrecord();

        List<String> Medications = new ArrayList<>();
        Medications.add("medicationTest");
        List<String> Allergies = new ArrayList<>();
        Allergies.add("allergiesTest");
        medicalrecord.setFirstName("firstNameTest");
        medicalrecord.setLastName("lastNameTest");
        medicalrecord.setBirthdate("birthdateTest");
        medicalrecord.setMedications(Medications);
        medicalrecord.setAllergies(Allergies);
        when(iMedicalRecordRepository.updateMedicalRecord(any(Medicalrecord.class))).thenReturn(medicalrecord);
        assertThat(medicalRecordService.updateMedicalRecord(medicalrecord).toString(), containsString("firstNameTest"));
    }

    @Test
    void deleteMedicalRecord() {
        Medicalrecord medicalrecord = new Medicalrecord();

        List<String> Medications = new ArrayList<>();
        Medications.add("medicationTest");
        List<String> Allergies = new ArrayList<>();
        Allergies.add("allergiesTest");
        medicalrecord.setFirstName("firstNameTest");
        medicalrecord.setLastName("lastNameTest");
        medicalrecord.setBirthdate("birthdateTest");
        medicalrecord.setMedications(Medications);
        medicalrecord.setAllergies(Allergies);
        when(iMedicalRecordRepository.deleteMedicalRecord(any(String.class), any(String.class))).thenReturn(medicalrecord);
        assertThat(medicalRecordService.deleteMedicalRecord("firstNameTest", "lastNameTest").toString(), containsString("firstNameTest"));
    }
}