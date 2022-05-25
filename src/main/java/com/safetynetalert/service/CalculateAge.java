package com.safetynetalert.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class CalculateAge {

    /*private int age;
    private int child;
    private int adult;

    public int getAdult() {
        return adult;
    }
    public int getAge() {
        return age;
    }
    public int getChild() {
        return child;
    }
    public void setChild(int child) {
        this.child = child;
    }
    public void setAdult(int adult) {
        this.adult = adult;
    }
    public void setAge(int age) {
        this.age = age;
    }**/

    public int calculateAge(String birthDate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate birth = LocalDate.parse(birthDate, formatter);
        LocalDate now = LocalDate.now();
        Period period = Period.between(birth, now);
        return period.getYears();
        /*age = period.getYears();

        if (age < 18) {
            child++;
        } else {
            adult++;
        }
        return age;**/
    }


}







