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
        List<Medicalrecord> findAllMedicalrecord = medicalRecordService.findAllMedicalrecord();
        if (findAllMedicalrecord == null) {
            Logger.error("getAllMedicalrecord FAILED");
        }else {
            Logger.info("getAllMedicalrecord SUCCESS");
        }
        return findAllMedicalrecord;
    }

    @PostMapping("/medicalrecord")
    public Medicalrecord addMedicalRecord(@RequestBody Medicalrecord medicalrecord){
        Medicalrecord addMedicalRecord  = medicalRecordService.addMedicalRecord(medicalrecord);

        if(addMedicalRecord == null){
            Logger.error("addMedicalRecord FAILED");
        }else{
            Logger.info("addMedicalRecord SUCCESS");
        }
        return addMedicalRecord;
    }
    @PutMapping("/medicalrecord")
    public Medicalrecord updateMedicalRecord(@RequestBody Medicalrecord medicalrecord){
        Medicalrecord updateMedicalRecord = medicalRecordService.updateMedicalRecord(medicalrecord);

        if(updateMedicalRecord == null){
            Logger.error("updateMedicalRecord FAILED");
        }else{
            Logger.info("updateMedicalRecord SUCCESS");
        }
        return updateMedicalRecord;
    }
    @DeleteMapping("/medicalrecord")
    public Medicalrecord deleteMedicalRecord(@RequestParam String firstName, @RequestParam String lastName){
        Medicalrecord deleteMedicalRecord = medicalRecordService.deleteMedicalRecord(firstName, lastName);
        if(deleteMedicalRecord == null){
            Logger.error("deleteMedicalRecord FAILED");
        }else{
            Logger.info("deleteMedicalRecord SUCCESS");
        }
        return deleteMedicalRecord;
    }
}
