package com.safetynetalert.repository;


import com.safetynetalert.model.Database;
import com.safetynetalert.model.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicalRecordRepository {
    private static ArrayList<MedicalRecord> medicalRecordList = new ArrayList<>();
    @Autowired
    private Database database;

    public List<MedicalRecord> findAll() {

        return database.getMedicalRecords();
    }

    public MedicalRecord addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordList.add(medicalRecord);
        return medicalRecord;
    }

    public void deleteMedicalRecord(String firstName, String lastName) {
        for (MedicalRecord medicalRecord : medicalRecordList) {
            if (medicalRecord.getFirstName().equals(firstName) && medicalRecord.getLastName().equals(lastName)) {
                medicalRecordList.remove(medicalRecord);
                break;
            }
        }

    }

    public MedicalRecord updateMedicalRecord(MedicalRecord updateMedicalRecord) {
        for (MedicalRecord medicalRecord : medicalRecordList) {
            if (medicalRecord.getFirstName().equals(updateMedicalRecord.getFirstName()) && medicalRecord.getLastName().equals(updateMedicalRecord.getLastName())) {
                medicalRecord.setBirthdate(updateMedicalRecord.getBirthdate());
                medicalRecord.setMedications(updateMedicalRecord.getMedications());
                medicalRecord.setAllergies(updateMedicalRecord.getAllergies());
                break;
            }
        }
        return updateMedicalRecord;
    }

    public MedicalRecord findOneMedicalRecord(String firstName, String lastName) {
        for (MedicalRecord medicalRecord : medicalRecordList) {
            if (medicalRecord.getFirstName().equals(firstName) && medicalRecord.getLastName().equals(lastName)) {
                return medicalRecord;
            }

        }return null;
    }
    /*public Person update(Person person) {
        Person personToUpdate = getByFirstNameAndLastName(person.getFirstName(), person.getLastName());
        if (personToUpdate != null) {
            personToUpdate.setFirstName(person.getFirstName());
            personToUpdate.setLastName(person.getLastName());
            personToUpdate.setAddress(person.getAddress());
            personToUpdate.setCity(person.getCity());
            personToUpdate.setZip(person.getZip());
            personToUpdate.setPhone(person.getPhone());
            personToUpdate.setEmail(person.getEmail());
        }
        return personToUpdate;
    }*/
}/* public Person deletePerson(String firstName, String lastName) {
        Person person = getByFirstNameAndLastName(firstName, lastName);
        if (person != null) {
            personsList.remove(person);

        }
        return person;
    }*/
