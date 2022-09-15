package com.safetynetalert.repository;


import com.safetynetalert.model.Database;
import com.safetynetalert.model.Medicalrecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicalrecordRepository implements IMedicalrecordRepository {
    public MedicalrecordRepository(){
        medicalrecords = Database.getMedicalrecords();
        System.out.println(" hello from MedicalRecordRepository");

    }
    List<Medicalrecord> medicalrecords;
    @Override
    public List<Medicalrecord> getAll() {
        return medicalrecords;
    }

    @Override
    public Medicalrecord addMedicalRecord(Medicalrecord medicalrecord) {
        medicalrecords.add(medicalrecord);
        return medicalrecord;
    }



    @Override
    public Medicalrecord updateMedicalRecord(Medicalrecord medicalrecord) {
        Medicalrecord medicalrecordToUpdate = getMedicalrecord(medicalrecord.getFirstName(), medicalrecord.getLastName());
        if (medicalrecordToUpdate != null) {
            medicalrecordToUpdate.setBirthdate(medicalrecord.getBirthdate());
            medicalrecordToUpdate.setMedications(medicalrecord.getMedications());
            medicalrecordToUpdate.setAllergies(medicalrecord.getAllergies());
        }
        return medicalrecordToUpdate;
    }



    @Override
    public Medicalrecord deleteMedicalRecord(String firstName, String lastName) {
        Medicalrecord medicalrecord = getMedicalrecord(firstName, lastName);
        if (medicalrecord != null) {
            medicalrecords.remove(medicalrecord);
        }
        return medicalrecord;
    }

    public Medicalrecord getMedicalrecord(String firstName, String lastName) {
        for (Medicalrecord medicalrecord : medicalrecords) {
            if (medicalrecord.getFirstName().equals(firstName) && medicalrecord.getLastName().equals(lastName)) {
                return medicalrecord;
            }
        }
        return null;
    }

}

