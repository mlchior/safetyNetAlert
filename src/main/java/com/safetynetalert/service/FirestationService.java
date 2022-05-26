package com.safetynetalert.service;
import com.safetynetalert.DTO.link1.PersonCoverByFirestation;
import com.safetynetalert.DTO.link1.StationInfo;
import com.safetynetalert.model.Firestation;
import com.safetynetalert.model.MedicalRecord;
import com.safetynetalert.model.Person;
import com.safetynetalert.repository.FirestationRepository;
import com.safetynetalert.repository.MedicalRecordRepository;
import com.safetynetalert.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class FirestationService {
    @Autowired
    private FirestationRepository firestationRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private MedicalRecordRepository medicalRecordRepository;


    public List<Firestation> findAllFirestation() {
        return firestationRepository.getAllFirestation();
    }

    public Firestation addFirestation(Firestation firestation) {
        return firestationRepository.addFirestation(firestation);
    }
    public void deleteFirestation(String adress) {
        firestationRepository.deleteFirestation(adress);
    }

    public Firestation updateFirestation(Firestation firestation) {
        return firestationRepository.updateFirestation(firestation);
    }

    /*public List<Person> findPersonByStation(int station) {
        List<Person> result = new ArrayList<>();

        for(Person person : personRepository.getAll()){
            if(person.getAdress().equals(firestationRepository.getFirestationByAdress(station).getAdress())){
                result.add(person);

            }
        }
        return result;

        }*/

    public Firestation findFirestationByAddress(String adress){
        return (firestationRepository.getFirestationByAddress(adress));
    }




   /* public List<PersonCoverByFirestation> findPersonsByStation(int station) {
        List<PersonCoverByFirestation> result = new ArrayList<>();
        List<Person> persons = personRepository.getAll();
        for (Person person : persons) {
            if (person.getAdress().equals(firestationRepository.getFirestationByAdress(station).getAdress())) {
                PersonCoverByFirestation personCoverByStation = new PersonCoverByFirestation();
                personCoverByStation.setFirstName(person.getFirstName());
                personCoverByStation.setLastName(person.getLastName());
                personCoverByStation.setAddress(person.getAdress());
                personCoverByStation.setPhone(person.getPhone());
                result.add(personCoverByStation);
            }
        }
        System.out.println(result);
        return result;

    }*/
    /*retourner une liste des personnes couvertes par la caserne de pompiers correspondante.
Donc, si le numéro de station = 1, elle doit renvoyer les habitants couverts par la station numéro 1. La liste
doit inclure les informations spécifiques suivantes : prénom, nom, adresse, numéro de téléphone. De plus,
elle doit fournir un décompte du nombre d'adultes et du nombre d'enfants (tout individu âgé de 18 ans ou
moins) dans la zone desservie.**/



    public List<StationInfo> findStationInfo(int station) {
        List<StationInfo> stationInfosList = new ArrayList<>();
        List<PersonCoverByFirestation> personCoverByFirestationList = new ArrayList<>();
        List<Person> persons = personRepository.getAll();
        List<MedicalRecord> MedicalRecords = medicalRecordRepository.findAll();
        List<Integer> ageList = new ArrayList<>();
        int numberOfAdult = 0;
        int numberOfChild = 0;

        String adress = firestationRepository.getFirestationByAdress(station).getAdress().toLowerCase();
        for (Person person : persons) {
            if (person.getAdress().toLowerCase().equals(adress)) {
                PersonCoverByFirestation personCoverByStation = new PersonCoverByFirestation();
                personCoverByStation.setFirstName(person.getFirstName());
                personCoverByStation.setLastName(person.getLastName());
                personCoverByStation.setAddress(person.getAdress());
                personCoverByStation.setPhone(person.getPhone());
                personCoverByFirestationList.add(personCoverByStation);

            }
            //findMedicalRecordByFirstNameAndLastName of personCoverByFirestationList and return all birthDate
            for (PersonCoverByFirestation personCoverByFirestation : personCoverByFirestationList) {
                for (MedicalRecord medicalRecord : MedicalRecords) {
                    if (medicalRecord.getFirstName().equals(personCoverByFirestation.getFirstName()) && medicalRecord.getLastName().equals(personCoverByFirestation.getLastName())) {
                        personCoverByFirestation.setBirthDate(medicalRecord.getBirthDate());
                    }
                }
            }
        }
        //Calculate age of each person and add it to the list
        for (PersonCoverByFirestation personCoverByFirestation : personCoverByFirestationList) {
            LocalDate birth = personCoverByFirestation.getBirthDate();
            LocalDate now = LocalDate.now();
            Period period = Period.between(birth, now);
            personCoverByFirestation.setAge(period.getYears());
        }



        for (PersonCoverByFirestation personCoverByFirestation : personCoverByFirestationList) {
            if (personCoverByFirestation.getAge() >= 18) {
                numberOfAdult++;
            }else{
                        numberOfChild++;
            }

        }
        //create new StationInfo  and add it to the list
        StationInfo stationInfo = new StationInfo(personCoverByFirestationList, numberOfAdult, numberOfChild);
        stationInfo.setNumberOfAdult(numberOfAdult);
        stationInfo.setNumberOfChild(numberOfChild);
        stationInfosList.add(stationInfo);
        return stationInfosList;
    }
//Cette url doit retourner une liste des numéros de téléphone des résidents desservis par la caserne de
//pompiers. Nous l'utiliserons pour envoyer des messages texte d'urgence à des foyers spécifiques.
    public List<String> findPhoneAlert(int station) {
    List<String> phoneAlertList = new ArrayList<>();
    List<Person> persons = personRepository.getAll();
    String adress = firestationRepository.getFirestationByAdress(station).getAdress().toLowerCase();
    for (Person person : persons) {
        if (person.getAdress().toLowerCase().equals(adress)) {
            phoneAlertList.add(person.getPhone());
        }
    }
    return phoneAlertList;
    }
}











   /* public List<PersonInfo> findPersonsByStation(int station) {
        List<Person> personList = new ArrayList<>();
        List<PersonInfo> personInfoList = new ArrayList<>();

        String adressStation = firestationRepository.getFirestationByAdress(station).getAdress();

        for(Person person : personList){

            PersonInfo personInfo = new PersonInfo(person.getLastName(), person.getAdress(),person.getAge(),person.getEmail());


          MedicalRecord medicalRecord = medicalRecordService.getOneMedicalRecord(person.getFirstName(),person.getLastName());
             // pour chaque medicalRecord je doit recuperer la date de naissance pour calculer l'age
            //cette age je le stock dans une variable
            // creer objet personInfo avec tous le sinformation recuperer dans une variable avant
            // ajouter a personInfoList
            //if personList.lastname and surname == lastandsurname de MedicalRecordReposo findOneMedicalRecord

        }
        for(Person person : personRepository.getAll()){
            if(person.getAdress().equals(adressStation)){
                personList.add(person);
            }
        }
        return personInfoList;

    }*/


/*
    newliststation
    newListgens;

    je recoi en paramettre une station;
    ca renvoi Listadress de cette station;
    pour chaque une des adress de la liststation;
    jajoute a ma liste gens les gens habitant a chacune de ces adress*/

    /**LINK 2*/















  /*  public Firestation saveFirestation(Firestation firestation) {
        Firestation savedFirestation = firestationRepository.saveFirestation(firestation);

        return savedFirestation;
    }**/


