package com.safetynetalert.controller;

import com.safetynetalert.model.MedicalRecord;
import com.safetynetalert.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MedicalRecordController {
    @Autowired
    private MedicalRecordService medicalRecordService;

    @GetMapping("/medicalRecord")
    public Iterable<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordService.getAllMedicalRecords();
    }
    @PostMapping("/medicalRecord")
    public MedicalRecord addMedicalRecord(MedicalRecord medicalRecord) {
        return medicalRecordService.addMedicalRecord(medicalRecord);
    }
    @DeleteMapping("/medicalRecord")
    public void deleteMedicalRecord(@RequestParam String firstName, @RequestParam String lastName) {
        medicalRecordService.deleteMedicalRecord(firstName, lastName);
    }
    @PutMapping("/medicalRecord")
    // update the medical record using the first name and last name
    public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord) {
        return medicalRecordService.updateMedicalRecord(medicalRecord);
    }

}
