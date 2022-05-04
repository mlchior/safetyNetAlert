package com.safetynetalert.controller;

import com.safetynetalert.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicalRecordController {
    @Autowired
    private MedicalRecordService medicalRecordService;
}
