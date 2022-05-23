package com.safetynetalert.repository;


import com.safetynetalert.model.MedicalRecord;
import com.safetynetalert.service.MedicalRecordService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Repository
public class MedicalRecordRepository {
    private static ArrayList<MedicalRecord> medicalRecordList = new ArrayList<>();
    private static ArrayList<String> medication1 = new ArrayList<>();
    private static ArrayList<String> allergies1 = new ArrayList<>();
    private static List<String> medication2 = new ArrayList<>();
    private static List<String> allergies2 = new ArrayList<>();
    public static void initMedicalRecordList() {
        medication1.add("Aspirin");
        medication1.add("Paracetamol");
        medication1.add("Ibuprofen");

        allergies1.add("Penicillin");
        medication2.add("Aspirin");
        medication2.add("Paracetamol");
        medication2.add("Ibuprofen");
        allergies2.add("Penicillin");
        allergies2.add("Sulfa");
        Date date = new Date("01/01/1990");
        medicalRecordList.add(new MedicalRecord("John", "Doe", date,medication1,allergies1));
        medicalRecordList.add(new MedicalRecord("Didier", "maraux", date,medication2,allergies2));
    }


    public List<MedicalRecord> findAll() {
        return medicalRecordList;
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
                medicalRecord.setBirthDate(updateMedicalRecord.getBirthDate());
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
