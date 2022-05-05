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
    public static void initMedicalRecordList() {
        medication1.add("Aspirin");
        medication1.add("Paracetamol");
        medication1.add("Ibuprofen");

        allergies1.add("Penicillin");
        Date date = new Date("01/01/1990");
        medicalRecordList.add(new MedicalRecord("John", "Doe", date,medication1,allergies1));
    }


 public static MedicalRecord getMedicalRecordByFirstNameAndLastName (String firstName, String lastName) {
     for (MedicalRecord medicalRecord : medicalRecordList) {
         if (medicalRecord.getFirstName().equals(firstName) && medicalRecord.getLastName().equals(lastName)) {
             return medicalRecord;
         }
     }
     return null;
 }



}
