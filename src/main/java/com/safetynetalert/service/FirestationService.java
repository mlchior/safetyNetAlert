package com.safetynetalert.service;
import com.safetynetalert.DTO.link1.PersonCoverByFirestation;
import com.safetynetalert.DTO.link1.StationNumber;
import com.safetynetalert.model.Firestation;
import com.safetynetalert.model.Medicalrecord;
import com.safetynetalert.model.Person;
import com.safetynetalert.repository.FirestationRepository;
import com.safetynetalert.repository.IFirestationRepository;
import com.safetynetalert.repository.IMedicalrecordRepository;
import com.safetynetalert.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tinylog.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Service
public class FirestationService {
    @Autowired
    private IFirestationRepository iFirestationRepository;
    @Autowired
    private IPersonRepository iPersonRepository;
    @Autowired
    private IMedicalrecordRepository iMedicalrecordRepository;

    public List<Firestation> findAllFirestation() {
        Logger.info("findAllFirestation SUCCESS");
        return iFirestationRepository.getAll();
    }
    public Firestation addFirestation(Firestation firestation) {
        Logger.info("addFirestation SUCCESS" + firestation);
        return iFirestationRepository.addFirestation(firestation);
    }
    public Firestation updateFirestation(Firestation firestation) {
        Logger.info("updateFirestation SUCCESS" + firestation);
        return iFirestationRepository.updateFirestation(firestation);
    }
    public Firestation deleteFirestation(String address) {
        Logger.info("deleteFirestation SUCCESS" + address);
        return iFirestationRepository.deleteFirestation(address);
    }

    public List<StationNumber> findStationInfo(int station) {
        List<StationNumber> stationInfoList = new ArrayList<>();
        List<PersonCoverByFirestation> personCoverByFirestationList = new ArrayList<>();
        List<Firestation> firestationList = findAllFirestationByStation(station);
        List<Person> persons = iPersonRepository.getAll();
        List<Medicalrecord> Medicalrecords = iMedicalrecordRepository.getAll();
        int numberOfAdult = 0;
        int numberOfChild = 0;

        for (Person person : persons) {
            for(Firestation firestation : firestationList){
                if (person.getAddress().toLowerCase().equals(firestation.getAddress().toLowerCase())) {
                    PersonCoverByFirestation personCoverByFirestation = new PersonCoverByFirestation();
                    personCoverByFirestation.setFirstName(person.getFirstName());
                    personCoverByFirestation.setLastName(person.getLastName());
                    personCoverByFirestation.setAddress(person.getAddress());
                    personCoverByFirestation.setPhone(person.getPhone());
                    personCoverByFirestationList.add(personCoverByFirestation);
            }}

        }
        for (PersonCoverByFirestation personCoverByFirestation : personCoverByFirestationList) {
            for (Medicalrecord medicalrecord : Medicalrecords) {
                if (medicalrecord.getFirstName().equals(personCoverByFirestation.getFirstName()) && medicalrecord.getLastName().equals(personCoverByFirestation.getLastName())) {
                    personCoverByFirestation.setBirthDate(medicalrecord.getBirthdate());
                }
            }
        }
        for (PersonCoverByFirestation personCoverByFirestation : personCoverByFirestationList) {
            Date date = null;
            Date date2 = null;
            date2 = new Date();


            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            try {
               date = dateFormat.parse(personCoverByFirestation.getBirthDate());
               date2 = dateFormat.parse(dateFormat.format(date2));


            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            long time = date2.getTime() - date.getTime();
            // convertir le temps en année
            int years = (int) (time / (1000 * 60 * 60 * 24 * 365));

            personCoverByFirestation.setAge(years);

        }
        for (PersonCoverByFirestation personCoverByFirestation : personCoverByFirestationList) {
            if (personCoverByFirestation.getAge() >= 18) {
                numberOfAdult++;
            } else {
                numberOfChild++;
            }
        }
        StationNumber stationInfo = new StationNumber(personCoverByFirestationList, numberOfAdult, numberOfChild);
        stationInfo.setNumberOfAdult(numberOfAdult);
        stationInfo.setNumberOfChild(numberOfChild);
        stationInfoList.add(stationInfo);
        return stationInfoList;

    }




    public List<String> findPhoneAlert(int station) {
        List<String> phoneAlertList = new ArrayList<>();
        List<Person> persons = iPersonRepository.getAll();
        String address = iFirestationRepository.getFirestationByStation(station).getAddress();
        for (Person person : persons) {
            if (person.getAddress().toLowerCase().equals(address.toLowerCase())) {
                phoneAlertList.add(person.getPhone());
            }
        }
        return phoneAlertList;
    }

    public List<Firestation> findAllFirestationByStation(int station) {
        // forEach firestations of the list, if the station is the same as the station we want, add it to the list
        List<Firestation> firestations = iFirestationRepository.getAll();
        List<Firestation> firestationsByStation = new ArrayList<>();
        for (Firestation firestation : firestations) {
            if (firestation.getStation() == station) {
                firestationsByStation.add(firestation);
            }

        }

        return firestationsByStation;
    }





}
