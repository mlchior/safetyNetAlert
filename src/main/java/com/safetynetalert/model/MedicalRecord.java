package com.safetynetalert.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;


@Data
public class MedicalRecord {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private List<String> medications;
    private List<String> allergies;
}
public class MedicalRecord(String firstName, String lastName, Date BirthDate, List<String> medications, List<String> allergies){


}
