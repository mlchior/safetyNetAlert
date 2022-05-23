package com.safetynetalert.service;

import com.safetynetalert.model.MedicalRecord;
import com.safetynetalert.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordService {
    @Autowired
    private MedicalRecordRepository medicalRecordRepository;


    public Iterable<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordRepository.findAll();
    }

    public MedicalRecord addMedicalRecord(MedicalRecord medicalRecord) {
        return medicalRecordRepository.addMedicalRecord(medicalRecord);
    }

    public void deleteMedicalRecord(String firstName, String lastName) {
        medicalRecordRepository.deleteMedicalRecord(firstName, lastName);
    }
    /*public getOneMedicalRecord(String firstName, String lastName){
        medicalRecordRepository.findOneMedicalRecord(firstName,lastName);
    }*/

    public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord) {
        return medicalRecordRepository.updateMedicalRecord(medicalRecord);
    }

}
