package com.safetynetalert.service;

import com.safetynetalert.DTO.link2.AgeOfPersons;
import com.safetynetalert.DTO.link2.ChildAlert;
import com.safetynetalert.DTO.link3.PhoneAlert;
import com.safetynetalert.model.Medicalrecord;
import com.safetynetalert.model.Person;
import com.safetynetalert.repository.FirestationRepository;
import com.safetynetalert.repository.IMedicalrecordRepository;
import com.safetynetalert.repository.IPersonRepository;
import com.safetynetalert.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tinylog.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;



@Service
public class PersonService {
    @Autowired
    private IPersonRepository iPersonRepository;
    @Autowired
    private IMedicalrecordRepository iMedicalrecordRepository;

    public List<Person> findAllPerson() {
        Logger.info("findAllPerson SUCCESS");
        return iPersonRepository.getAll();
    }

    public Person addPerson(Person person) {
        Logger.info("addPerson SUCCESS" + person);
        return iPersonRepository.addPerson(person);
    }

    public Person updatePerson(Person person) {
        Logger.info("updatePerson SUCCESS" + person);
        return iPersonRepository.updatePerson(person);
    }

    public Person deletePerson(String firstName, String lastName) {
        Logger.info("deletePerson SUCCESS" + firstName + lastName);
        return iPersonRepository.deletePerson(firstName, lastName);
    }

    public List<String> getCommunityEmail(String city) {
        Logger.info("getCommunityEmail SUCCESS" + city);
        return iPersonRepository.getCommunityEmail(city);
    }

    public Collection<Object> getPersonInfo(String firstName, String lastName) {
        Logger.info("getPersonInfo SUCCESS" + firstName + lastName);
        return iPersonRepository.getPersonInfo(firstName, lastName);
    }

    public List<ChildAlert> getChildAlert(String address) {
        List<AgeOfPersons> ageOfPersonsList = new ArrayList<>();
        List<ChildAlert> childAlertList = new ArrayList<>();
        List<Person> persons = iPersonRepository.getAll();
        List<Medicalrecord> medicalRecords = iMedicalrecordRepository.getAll();

        for (Person person : persons) {
            if (person.getAddress().equals(address)) {
                AgeOfPersons ageOfPersons = new AgeOfPersons();
                ageOfPersons.setFirstName(person.getFirstName());
                ageOfPersons.setLastName(person.getLastName());
                // calculate age of ageOfPersons with medicalRecords
            }
            for (AgeOfPersons ageOfPersons : ageOfPersonsList) {
                for (Medicalrecord medicalrecord : medicalRecords) {
                    if (medicalrecord.getFirstName().equals(ageOfPersons.getFirstName()) && medicalrecord.getLastName().equals(ageOfPersons.getLastName())) {
                        ageOfPersons.setBirthDate(medicalrecord.getBirthdate());
                    }
                }
            }
            for (AgeOfPersons ageOfPersons : ageOfPersonsList) {
                Date date = null;
                Date date2 = null;
                date2 = new Date();

                DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                try {
                    date = dateFormat.parse(ageOfPersons.getBirthDate());
                    date2 = dateFormat.parse(dateFormat.format(date2));


                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                int age = date2.getYear() - date.getYear();
                ageOfPersons.setAge(age);
                System.out.println(ageOfPersons.getAge());
            }


        }

        /*  ---------------------------------------------------------------------------------------------------------------------*/


        return childAlertList;
    }
}