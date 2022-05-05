package com.safetynetalert.service;

import com.safetynetalert.model.MedicalRecord;
import com.safetynetalert.model.Person;
import com.safetynetalert.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordService {
    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    public MedicalRecord findMedicalRecordByfIrstNameAndLastName(String firstName, String lastName) {
        return medicalRecordRepository.getMedicalRecordByFirstNameAndLastName(firstName, lastName);
}

}
