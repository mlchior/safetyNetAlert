package com.safetynetalert.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class CalculateAge {
    private int age;
    private int child = 0;
    private int adult = 0;

    public int getAdult() {
        return adult;
    }

    public int getAge() {
        return age;
    }

    public void setChild(int child) {
        this.child = child;
    }

    public void setAdult(int adult) {
        this.adult = adult;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public int calculateAge(String birthdate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate birth = LocalDate.parse(birthdate, formatter);
        LocalDate now = LocalDate.now();
        Period period = Period.between(birth, now);
        age = period.getYears();

        if (age < 18) {
            child++;
        } else {
            adult++;
        }
        return age;
    }
}







