package com.safetynetalert.DTO.link1;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PersonCoverByFirestation {
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    @JsonIgnore
    private String birthDate;
    @JsonIgnore
    private int age;


    public PersonCoverByFirestation(String firstName, String lastName, String address, String phone, String birthDate, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.birthDate = birthDate;
        this.age = age;
    }

    public PersonCoverByFirestation() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

}
