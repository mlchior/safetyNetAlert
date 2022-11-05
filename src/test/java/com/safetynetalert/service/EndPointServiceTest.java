package com.safetynetalert.service;

import com.safetynetalert.DTO.link1.StationNumber;
import com.safetynetalert.DTO.link2.ChildAlert;
import com.safetynetalert.DTO.link4.Fire;
import com.safetynetalert.DTO.link4.PersonByAddress;
import com.safetynetalert.DTO.link5.AllFamilyByStation;
import com.safetynetalert.model.Firestation;
import com.safetynetalert.model.Medicalrecord;
import com.safetynetalert.model.Person;
import com.safetynetalert.repository.IFirestationRepository;
import com.safetynetalert.repository.IMedicalrecordRepository;
import com.safetynetalert.repository.IPersonRepository;
import org.apache.tomcat.jni.Address;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class EndPointServiceTest {

    @MockBean
    private IPersonRepository iPersonRepository;
    @MockBean
    private IFirestationRepository iFirestationRepository;
    @MockBean
    private IMedicalrecordRepository iMedicalrecordRepository;

    @MockBean
    private CalculateAgeService calculateAgeService;
    @Autowired
    private EndPointService endPointService;


    @Test
    public void findStationInfo() {
        int idStation = 1;
        List<Firestation> firestationList = new ArrayList<>();
        List<Person> persons = new ArrayList<>();
        List<Medicalrecord> medicalrecords = new ArrayList<>();

        Firestation firestation = new Firestation("addressTest", 1);
        firestationList.add(firestation);
        Person person = new Person("John", "Doe", "22 rue la clef des champs", "Les puces", "93400", "0634432234", "boulou@gmail.com");
        persons.add(person);
        person = new Person("firstNameTest", "lastNameTest", "addressTest", "cityTest", "93400", "0634432234", "boulou@gmail.com");
        persons.add(person);
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord = new Medicalrecord("firstNameTest", "lastNameTest", "01/01/2000", List.of(new String[]{"medicationTest"}), List.of(new String[]{"allergyTest"}));
        medicalrecords.add(medicalrecord);

        when(iPersonRepository.getAll()).thenReturn(persons);
        when(iMedicalrecordRepository.getAll()).thenReturn(medicalrecords);
        when(iFirestationRepository.findAllFirestationByStation(idStation)).thenReturn(firestationList);
        //then

        List<StationNumber> stationInfoList;
        stationInfoList = endPointService.findStationInfo(idStation);
        System.out.println(stationInfoList);
        assertTrue(stationInfoList.size() == 1);
    }

    @Test
    public void getChildAlert() {
        String address = "addressTest";
        List<Person> persons = new ArrayList<>();
        List<Medicalrecord> medicalrecords = new ArrayList<>();

        Person person = new Person("firstNameTest", "lastNameTest", "addressTest", "cityTest", "93400", "0634432234", "emailTest@gmail.com");
        persons.add(person);
        persons.add(new Person("firstNameTest2", "lastNameTest2", "addressTest", "cityTest", "93400", "0634432234", "emailTest2@gmail.com"));
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord = new Medicalrecord("firstNameTest", "lastNameTest", "01/01/2008", List.of(new String[]{"medicationTest"}), List.of(new String[]{"allergyTest"}));
        medicalrecords.add(medicalrecord);
        medicalrecord = new Medicalrecord("firstNameTest2", "lastNameTest2", "01/01/2000", List.of(new String[]{"medicationTest"}), List.of(new String[]{"allergyTest"}));
        //when(iPersonRepository.getAll()).thenReturn(persons);
        when(iMedicalrecordRepository.getAll()).thenReturn(medicalrecords);
        when(calculateAgeService.calculateAge("01/01/2008")).thenReturn(15);
        when(calculateAgeService.calculateAge("01/01/2000")).thenReturn(23);
        when(iPersonRepository.getPersonsByAddress(address)).thenReturn(persons);
        List<ChildAlert> childAlertList;
        childAlertList = endPointService.getChildAlert(address);
        assertTrue(childAlertList.size() == 1);
    }

    @Test
    public void findPhoneAlert() {
        int station = 1;
        List<String> phoneAlertList = new ArrayList<>();
        List<Firestation> firestations = new ArrayList<>();
        List<Person> persons = new ArrayList<>();
        Firestation firestation = new Firestation("addressTest", 1);
        firestations.add(firestation);
        Person person = new Person("firstNameTest", "lastNameTest", "addressTest", "cityTest", "93400", "000000000", "emailTest@gmail.com");
        persons.add(person);
        person = new Person("firstNameTest2", "lastNameTest2", "addressTest2", "cityTest", "93400", "0634432234", "emailTest@gmail.com");
        persons.add(person);
        when(iPersonRepository.getAll()).thenReturn(persons);
        when(iFirestationRepository.findAllFirestationByStation(station)).thenReturn(firestations);
        phoneAlertList = endPointService.findPhoneAlert(station);
        System.out.println(phoneAlertList);
        assertTrue(phoneAlertList.size() == 1);
        assertTrue(phoneAlertList.get(0).equals("000000000"));
    }


  /**  @Test
    @Ignore
    public void getFire() {
        List<PersonByAddress> personByAddressList = new ArrayList<>();
        List<Person> persons = new ArrayList<>();
        List<Medicalrecord> medicalrecords = new ArrayList<>();
        Fire fire = new Fire();


        Person person = new Person("firstNameTest", "lastNameTest", "addressTest", "cityTest", "93400", "0634432234", "emailTest@gmail.com");
        persons.add(person);
        person = new Person("firstNameTest2", "lastNameTest2", "addressTest2", "cityTest", "93400", "0634432234", "emailTest2@gmail.com");
        persons.add(person);
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord = new Medicalrecord("firstNameTest", "lastNameTest", "01/01/2000", List.of(new String[]{"medicationTest"}), List.of(new String[]{"allergyTest"}));
        medicalrecords.add(medicalrecord);
        medicalrecord = new Medicalrecord("firstNameTest2", "lastNameTest2", "01/01/2000", List.of(new String[]{"medicationTest"}), List.of(new String[]{"allergyTest"}));
        medicalrecords.add(medicalrecord);
        when(iPersonRepository.getAll()).thenReturn(persons);
        when(iMedicalrecordRepository.getAll()).thenReturn(medicalrecords);
        when(iFirestationRepository.findFirestationByAdress("addressTest")).thenReturn(Collections.singletonList(new Firestation("addressTest", 1)));
        when(iFirestationRepository.findFirestationByAdress("addressTest2")).thenReturn((List<Firestation>) new Firestation("addressTest2", 2));
        when(calculateAgeService.calculateAge("01/01/2000")).thenReturn(20);
        when(calculateAgeService.calculateAge("01/01/2000")).thenReturn(20);

        // personByAddressList = endPointService.getFire("addressTest");

        System.out.println(personByAddressList);
        assertTrue(personByAddressList.size() == 1);
        fire.setStation(1);
        System.out.println(fire);
        assertTrue(fire.getStation() == 1);
    }*/
    @Test
    public void getFlood() {
        List<AllFamilyByStation> allFamilyByStationList = new ArrayList<>();
        List<Firestation> firestations = new ArrayList<>();
        List<String> listdemesfirestations = new ArrayList<>();

        //given
        Firestation firestation = new Firestation("addressTest", 1);
        firestations.add(firestation);
        firestation = new Firestation("addressTest2", 2);
        firestations.add(firestation);
        listdemesfirestations.add("addressTest");
    }



}








