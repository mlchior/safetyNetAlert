package com.safetynetalert.DTO.link5;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class AllFamilyByStation {
    @JsonIgnore
    private String firstName;
    private String lastName;

    private int age;
    private String phone;
    private List<String> medications;
    private List<String> allergies;

    public AllFamilyByStation(String firstName, String lastName, int age, String phone, List<String> medications, List<String> allergies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.medications = medications;
        this.allergies = allergies;
    }

    public AllFamilyByStation() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

