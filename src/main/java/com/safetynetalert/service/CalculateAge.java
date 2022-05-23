package com.safetynetalert.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class CalculateAge {
 private int age;
 private int child = 0;
 private int adult = 0;

 public int calculateAge(String birthdate) {
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
     LocalDate birth = LocalDate.parse(birthdate, formatter);
     LocalDate now = LocalDate.now();
     Period period = Period.between(birth, now);
     age = period.getYears();
     return age;
 }

 public int getChild() {
     return child;
 }

 public int getAdult() {
     return adult;
 }

 public void setChild(int child) {
     this.child = child;
 }

 public void setAdult(int adult) {
     this.adult = adult;
 }
}



