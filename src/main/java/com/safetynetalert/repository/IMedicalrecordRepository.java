package com.safetynetalert.repository;
 import com.safetynetalert.model.Medicalrecord;
 import java.util.List;

public interface IMedicalrecordRepository {

    List<Medicalrecord> getAll();

    Medicalrecord addMedicalRecord(Medicalrecord medicalrecord);

    Medicalrecord updateMedicalRecord(Medicalrecord medicalrecord);

    Medicalrecord deleteMedicalRecord(String firstName, String lastName);
}
