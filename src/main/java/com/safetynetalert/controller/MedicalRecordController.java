package com.safetynetalert.controller;

import com.safetynetalert.model.MedicalRecord;
import com.safetynetalert.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicalRecordController {
    @Autowired
    private MedicalRecordService medicalRecordService;

    @GetMapping("/medicalRecord/{firstName}/{lastName}")
    public MedicalRecord getMedicalRecordByFirstNameAndLastName(@PathVariable String firstName, String lastName) {
        return medicalRecordService.findMedicalRecordByfIrstNameAndLastName(firstName, lastName);
    }
}
