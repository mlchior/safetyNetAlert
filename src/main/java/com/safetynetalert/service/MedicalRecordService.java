package com.safetynetalert.service;

import com.safetynetalert.model.Medicalrecord;
import com.safetynetalert.repository.IMedicalrecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tinylog.Logger;

import java.util.List;

@Service
public class MedicalRecordService {
    @Autowired
    private IMedicalrecordRepository iMedicalRecordRepository;

    public List<Medicalrecord> findAllMedicalrecord() {
        Logger.info("findAllMedicalrecord SUCCESS");
        return iMedicalRecordRepository.getAll();
    }

    public Medicalrecord addMedicalRecord(Medicalrecord medicalrecord) {
        Logger.info("addMedicalRecord SUCCESS" + medicalrecord);
        return iMedicalRecordRepository.addMedicalRecord(medicalrecord);
    }


    public Medicalrecord updateMedicalRecord(Medicalrecord medicalrecord) {
        Logger.info("updateMedicalRecord SUCCESS" + medicalrecord);
        return iMedicalRecordRepository.updateMedicalRecord(medicalrecord);
    }

    public Medicalrecord deleteMedicalRecord(String firstName, String lastName) {
        Logger.info("deleteMedicalRecord SUCCESS" + firstName + lastName);
        return iMedicalRecordRepository.deleteMedicalRecord(firstName, lastName);
    }
}
