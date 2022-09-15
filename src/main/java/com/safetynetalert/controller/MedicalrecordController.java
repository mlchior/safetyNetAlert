package com.safetynetalert.controller;
import com.safetynetalert.model.Medicalrecord;
import com.safetynetalert.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tinylog.Logger;

import java.util.List;

@RestController
public class MedicalrecordController {
    @Autowired
    private MedicalRecordService medicalRecordService;

    @GetMapping("/medicalrecord")
    public List<Medicalrecord> getAllMedicalrecord(){
        List<Medicalrecord> mr = medicalRecordService.findAllMedicalrecord();
        if (mr == null) {
            Logger.error("getAllMedicalrecord FAILED");
        }else {
            Logger.info("getAllMedicalrecord SUCCESS");
        }
        return mr;
    }

    @PostMapping("/medicalrecord")
    public Medicalrecord addMedicalRecord(@RequestBody Medicalrecord medicalrecord){
        Medicalrecord mr  = medicalRecordService.addMedicalRecord(medicalrecord);

        if(mr == null){
            Logger.error("addMedicalRecord FAILED");
        }else{
            Logger.info("addMedicalRecord SUCCESS");
        }
        Logger.info(medicalrecord.getBirthdate() + "hello" );
        return mr;
    }
    @PutMapping("/medicalrecord")
    public Medicalrecord updateMedicalRecord(@RequestBody Medicalrecord medicalrecord){
        Medicalrecord mr = medicalRecordService.updateMedicalRecord(medicalrecord);

        if(mr == null){
            Logger.error("updateMedicalRecord FAILED");
        }else{
            Logger.info("updateMedicalRecord SUCCESS");
        }
        return mr;
    }
    @DeleteMapping("/medicalrecord")
    public Medicalrecord deleteMedicalRecord(@RequestParam String firstName, @RequestParam String lastName){
        Medicalrecord mr = medicalRecordService.deleteMedicalRecord(firstName, lastName);
        if(mr == null){
            Logger.error("deleteMedicalRecord FAILED");
        }else{
            Logger.info("deleteMedicalRecord SUCCESS");
        }
        return mr;
    }

}
