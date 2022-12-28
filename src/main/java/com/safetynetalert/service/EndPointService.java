package com.safetynetalert.service;
import com.safetynetalert.DTO.PersonInfo;
import com.safetynetalert.DTO.link1.PersonCoverByFirestation;
import com.safetynetalert.DTO.link2.AgeOfPersons;
import com.safetynetalert.DTO.link2.ChildAlert;
import com.safetynetalert.DTO.link4.Fire;
import com.safetynetalert.DTO.link4.PersonByAddress;
import com.safetynetalert.DTO.link5.AllFamilyByStation;
import com.safetynetalert.repository.IFirestationRepository;
import com.safetynetalert.repository.IMedicalrecordRepository;
import com.safetynetalert.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.safetynetalert.DTO.link1.StationNumber;
import com.safetynetalert.model.Firestation;
import com.safetynetalert.model.Medicalrecord;
import com.safetynetalert.model.Person;
import org.tinylog.Logger;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
public class EndPointService {

    @Autowired
    IPersonRepository iPersonRepository;
    @Autowired
    IMedicalrecordRepository iMedicalRecordRepository;
    @Autowired
    IFirestationRepository iFirestationRepository;
    @Autowired
    CalculateAgeService calculateAgeService;

    public List<StationNumber> findStationInfo(int station) {
        List<StationNumber> stationInfoList = new ArrayList<>();
        List<PersonCoverByFirestation> personCoverByFirestationList = new ArrayList<>();
        List<Firestation> firestationList = iFirestationRepository.findAllFirestationByStation(station);
        List<Person> persons = iPersonRepository.getAll();
        List<Medicalrecord> Medicalrecords = iMedicalRecordRepository.getAll();
        int numberOfAdult = 0;
        int numberOfChild = 0;
        Logger.info("findStationInfo SUCCESS" + station);
        for (Person person : persons) {
            for (Firestation firestation : firestationList) {
                if (person.getAddress().toLowerCase().equals(firestation.getAddress().toLowerCase())) {
                    PersonCoverByFirestation personCoverByFirestation = new PersonCoverByFirestation();
                    personCoverByFirestation.setFirstName(person.getFirstName());
                    personCoverByFirestation.setLastName(person.getLastName());
                    personCoverByFirestation.setAddress(person.getAddress());
                    personCoverByFirestation.setPhone(person.getPhone());
                    personCoverByFirestationList.add(personCoverByFirestation);
                }
            }

        }
        for (PersonCoverByFirestation personCoverByFirestation : personCoverByFirestationList) {
            for (Medicalrecord medicalrecord : Medicalrecords) {
                if (medicalrecord.getFirstName().equals(personCoverByFirestation.getFirstName()) && medicalrecord.getLastName().equals(personCoverByFirestation.getLastName())) {
                    personCoverByFirestation.setBirthDate(medicalrecord.getBirthdate());
                }
            }
        }
        for (PersonCoverByFirestation personCoverByFirestation : personCoverByFirestationList) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            int years = Period.between(LocalDate.parse(personCoverByFirestation.getBirthDate(), formatter), LocalDate.now()).getYears();
            personCoverByFirestation.setAge(years);
            System.out.println(personCoverByFirestation.getAge());
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

    // 2 childAlert
    public List<ChildAlert> getChildAlert(String address) {
        Logger.info("getChildAlert SUCCESS" + address);
        List<Person> listPersonsByAddress = iPersonRepository.getPersonsByAddress(address);
        List<AgeOfPersons> ageOfPersonsList = new ArrayList<>();
        List<Medicalrecord> medicalRecords = iMedicalRecordRepository.getAll();
        List<AgeOfPersons> adulte = new ArrayList<>();
        List<AgeOfPersons> enfant = new ArrayList<>();
        List<ChildAlert> childAlertsList = new ArrayList<>();
        for (Person person : listPersonsByAddress) {
            for (Medicalrecord medicalrecord : medicalRecords) {
                if (person.getFirstName().equals(medicalrecord.getFirstName()) && person.getLastName().equals(medicalrecord.getLastName())) {
                    AgeOfPersons ageOfPersons = new AgeOfPersons();
                    ageOfPersons.setFirstName(person.getFirstName());
                    ageOfPersons.setLastName(person.getLastName());
                    ageOfPersons.setAge(calculateAgeService.calculateAge(medicalrecord.getBirthdate()));
                    ageOfPersonsList.add(ageOfPersons);
                }
            }
        }

        for (AgeOfPersons ageOfPersons : ageOfPersonsList) {
            if (ageOfPersons.getAge() < 18) {
                enfant.add(ageOfPersons);
            } else {
                adulte.add(ageOfPersons);
            }
        }

        for (AgeOfPersons ageOfPersons : enfant) {
            ChildAlert childAlert = new ChildAlert();
            childAlert.setFirstName(ageOfPersons.getFirstName());
            childAlert.setLastName(ageOfPersons.getLastName());
            childAlert.setAge(ageOfPersons.getAge());
            childAlert.setPersonWithChild(adulte);
            childAlertsList.add(childAlert);
        }

        return childAlertsList;
    }
    //3 phoneAlert
    public List<String> findPhoneAlert(int station) {
        Logger.info("findPhoneAlert SUCCESS" + station);
        List<String> phoneAlertList = new ArrayList<>();
        List<Firestation> firestations = iFirestationRepository.findAllFirestationByStation(station);
        List<Person> persons = iPersonRepository.getAll();
        for (Person person : persons) {
            for (Firestation firestation : firestations) {
                if (person.getAddress().toLowerCase().equals(firestation.getAddress().toLowerCase())) {
                    phoneAlertList.add(person.getPhone());
                }
            }
        }
        return phoneAlertList;
    }
    //4 fire

    public Fire getFire(String address) {
        Logger.info("getFire SUCCESS" + address);
        List<PersonByAddress> personByAddressList = new ArrayList<>();
        List<Person> persons = iPersonRepository.getPersonsByAddress(address);
        List<Medicalrecord> medicalRecords = iMedicalRecordRepository.getAll();
        List<Fire> fireList = new ArrayList<>();

        for (Person person : persons) {
            for (Medicalrecord medicalrecord : medicalRecords) {
                if (person.getFirstName().equals(medicalrecord.getFirstName()) && person.getLastName().equals(medicalrecord.getLastName())) {
                    PersonByAddress personByAddress = new PersonByAddress();
                    personByAddress.setFirstName(person.getFirstName());
                    personByAddress.setLastName(person.getLastName());
                    personByAddress.setAge(calculateAgeService.calculateAge(medicalrecord.getBirthdate()));
                    personByAddress.setPhone(person.getPhone());
                    personByAddress.setMedications(medicalrecord.getMedications());
                    personByAddress.setAllergies(medicalrecord.getAllergies());
                    personByAddressList.add(personByAddress);
                }
            }
        }
        Fire fire = null;
        for (PersonByAddress personByAddress : personByAddressList) {
            fire = new Fire();
            fire.setStation(iFirestationRepository.findFirestationByAdress(address));
            fire.setPersonByAdress(personByAddressList);
            fireList.add(fire);
        }
        return fire;
    }


    //5 flood/stations
   public List<AllFamilyByStation> getFlood(List<Integer> stations) {
        Logger.info("getFlood SUCCESS" + stations);
        List<AllFamilyByStation> allFamilyByStationList = null;
        List <Firestation> firestations = new ArrayList<>();
        List <String> listdemesfirestation;
        allFamilyByStationList = new ArrayList<>();
        listdemesfirestation = new ArrayList<>();
        for (int s : stations){
            listdemesfirestation.addAll(iFirestationRepository.findAllAddressByStation(s));
        }
            for (String address : listdemesfirestation) {
                List<Person> persons = iPersonRepository.getPersonsByAddress(address);
                List<Medicalrecord> medicalRecords = iMedicalRecordRepository.getAll();
                for (Person person : persons) {
                    for (Medicalrecord medicalrecord : medicalRecords) {
                        if (person.getFirstName().equals(medicalrecord.getFirstName()) && person.getLastName().equals(medicalrecord.getLastName())) {
                            AllFamilyByStation allFamilyByStation = new AllFamilyByStation();
                            allFamilyByStation.setFirstName(person.getFirstName());
                            allFamilyByStation.setLastName(person.getLastName());
                            allFamilyByStation.setPhone(person.getPhone());
                            allFamilyByStation.setAge(calculateAgeService.calculateAge(medicalrecord.getBirthdate()));
                            allFamilyByStation.setMedications(medicalrecord.getMedications());
                            allFamilyByStation.setAllergies(medicalrecord.getAllergies());
                            allFamilyByStationList.add(allFamilyByStation);
                        }
                    }
                }
            }

        return allFamilyByStationList;
    }
    //6 personInfo
    public List<PersonInfo> getPersonInfo(String firstName, String lastName) {
        Logger.info("getPersonInfo : " + firstName + " " + lastName);
        List<PersonInfo> personInfoList = new ArrayList<>();
        List<Person> persons = iPersonRepository.getAll();
        List<Medicalrecord> medicalRecords = iMedicalRecordRepository.getAll();
        for (Person person : persons) {
            if (person.getLastName().equals(lastName)&& person.getFirstName().equals(firstName)) {
                PersonInfo personInfo = new PersonInfo();
                personInfo.setFirstName(person.getFirstName());
                personInfo.setLastName(person.getLastName());
                personInfo.setAddress(person.getAddress());
                personInfo.setEmail(person.getEmail());
                for (Medicalrecord medicalrecord : medicalRecords) {
                    if (person.getFirstName().equals(medicalrecord.getFirstName()) && person.getLastName().equals(medicalrecord.getLastName())) {
                        personInfo.setAge(calculateAgeService.calculateAge(medicalrecord.getBirthdate()));
                        personInfo.setMedications(medicalrecord.getMedications());
                        personInfo.setAllergies(medicalrecord.getAllergies());
                    }
                }
                personInfoList.add(personInfo);
            }
        }
        return personInfoList;
    }

    //7 communityEmail
    public List<String> getCommunityEmail(String city) {
        Logger.info("getCommunityEmail SUCCESS" + city);
        List<String> communityEmailList = new ArrayList<>();
        List<Person> persons = iPersonRepository.getAll();
        for (Person person : persons) {
            if (person.getCity().toLowerCase().equals(city.toLowerCase())) {
                communityEmailList.add(person.getEmail());
            }
        }
        return communityEmailList;
    }





}




