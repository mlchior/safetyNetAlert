package com.safetynetalert.service;

import com.safetynetalert.DTO.PersonInfo;
import com.safetynetalert.DTO.link1.StationNumber;
import com.safetynetalert.DTO.link2.ChildAlert;
import com.safetynetalert.DTO.link4.Fire;
import com.safetynetalert.DTO.link5.AllFamilyByStation;
import com.safetynetalert.model.Firestation;
import com.safetynetalert.model.Medicalrecord;
import com.safetynetalert.model.Person;
import com.safetynetalert.repository.IFirestationRepository;
import com.safetynetalert.repository.IMedicalrecordRepository;
import com.safetynetalert.repository.IPersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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

    @Test
    @DisplayName(" getFire when personLastName is equal to medicalRecordLastName")
    public void getFire() {
        String address = "address";

        List<Person> persons = new ArrayList<>();

        Person person = new Person();
        person.setFirstName("jean");
        person.setLastName("michel");

        persons.add(person);

        List<Medicalrecord> medicalRecords = new ArrayList<>();
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord.setFirstName("jean");
        medicalrecord.setLastName("michel");
        medicalrecord.setBirthdate("1995");

        medicalRecords.add(medicalrecord);


        when(iPersonRepository.getPersonsByAddress(address)).thenReturn(persons);
        when(iMedicalrecordRepository.getAll()).thenReturn(medicalRecords);
        when(calculateAgeService.calculateAge(medicalrecord.getBirthdate())).thenReturn(1995);

        Fire fire = endPointService.getFire(address);
        assertNotNull(fire);
        Assertions.assertEquals(1, fire.getPersonByAdress().size());

    }


    @Test
    @DisplayName(" getFire when personLastName is not equal to medicalRecordLastName")
    public void getFire1() {
        String address = "address";

        List<Person> persons = new ArrayList<>();

        Person person = new Person();
        person.setFirstName("jean");
        person.setLastName("michel");

        persons.add(person);

        List<Medicalrecord> medicalRecords = new ArrayList<>();
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord.setFirstName("sara");
        medicalrecord.setLastName("hanon");
        medicalrecord.setBirthdate("1995");

        medicalRecords.add(medicalrecord);


        when(iPersonRepository.getPersonsByAddress(address)).thenReturn(persons);
        when(iMedicalrecordRepository.getAll()).thenReturn(medicalRecords);
        when(calculateAgeService.calculateAge(medicalrecord.getBirthdate())).thenReturn(1995);

        Fire fire = endPointService.getFire(address);
        assertNull(fire);
    }

    @Test
    public void getFlood() {

        List<Integer> stations = new ArrayList<>();
        List<String> stringList = new ArrayList<>();

        stations.add(2);
        stringList.add("addresstwo");

        List<Person> persons = new ArrayList<>();

        Person person = new Person();
        person.setFirstName("jean");
        person.setLastName("michel");

        persons.add(person);

        List<Medicalrecord> medicalRecords = new ArrayList<>();
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord.setFirstName("jean");
        medicalrecord.setLastName("michel");
        medicalrecord.setBirthdate("1995");

        medicalRecords.add(medicalrecord);

        when(iFirestationRepository.findAllAddressByStation(2)).thenReturn(stringList);
        when(iPersonRepository.getPersonsByAddress("addresstwo")).thenReturn(persons);
        when(iMedicalrecordRepository.getAll()).thenReturn(medicalRecords);
        when(calculateAgeService.calculateAge(medicalrecord.getBirthdate())).thenReturn(1995);

        List<AllFamilyByStation> allFamilyByStations=  endPointService.getFlood(stations);

        assertEquals(1, allFamilyByStations.size());
        assertNotNull(allFamilyByStations.get(0));
    }

    @Test
    public void getPersonInfo() {
        List<Person> persons = new ArrayList<>();

        Person person = new Person();
        person.setFirstName("jean");
        person.setLastName("michel");

        persons.add(person);

        List<Medicalrecord> medicalRecords = new ArrayList<>();
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord.setFirstName("jean");
        medicalrecord.setLastName("michel");
        medicalrecord.setBirthdate("1995");

        medicalRecords.add(medicalrecord);

        when(iPersonRepository.getAll()).thenReturn(persons);
        when(iMedicalrecordRepository.getAll()).thenReturn(medicalRecords);
        when(calculateAgeService.calculateAge(medicalrecord.getBirthdate())).thenReturn(1995);

        List<PersonInfo>  personInfos= endPointService.getPersonInfo("jean", "michel");

        assertEquals(1,personInfos.size());
        assertNotNull(personInfos.get(0));

    }

    @Test
    public void getCommunityEmail() {
        List<Person> persons = new ArrayList<>();

        Person person = new Person();
        person.setCity("city");
        person.setEmail("email");

        persons.add(person);

        when(iPersonRepository.getAll()).thenReturn(persons);

        List<String> stringList= endPointService.getCommunityEmail("city");
        assertEquals("email", stringList.get(0));
    }
    @Test
    public void getCommunityEmailWithWrongEmail() {
        List<Person> persons = new ArrayList<>();

        Person person = new Person();
        person.setCity("city");
        person.setEmail("email");

        persons.add(person);

        when(iPersonRepository.getAll()).thenReturn(persons);

        List<String> stringList= endPointService.getCommunityEmail("city");
        assertNotEquals("email2", stringList.get(0));
    }

}









