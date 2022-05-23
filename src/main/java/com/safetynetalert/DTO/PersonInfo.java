package com.safetynetalert.DTO;

import java.util.List;


public class PersonInfo {
    private String lastName;
    private String adress;
    private int age;
    private String email;
    private List<String> medications;
    private List<String> allergies;

public PersonInfo(String lastName, String adress, int age, String email, List<String>medications,List<String>allergies){
    this.lastName = lastName;
    this.adress = adress;
    this.age = age;
    this.email = email;
    this.medications = medications;
    this.allergies = allergies;
}

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getMedications() {
        return medications;
    }

    public void setMedications(List<String> medications) {
        this.medications = medications;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }
}


