package com.safetynetalert.service;

import com.safetynetalert.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
@Service
public class CalculateAgeService {

    @Autowired
    IPersonRepository iPersonRepository;

    public int calculateAge(String birthdate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        int years = Period.between(LocalDate.parse(birthdate, formatter), LocalDate.now()).getYears();
        return years;
    }
}
