package com.safetynetalert.service;
import com.safetynetalert.DTO.link1.PersonCoverByFirestation;
import com.safetynetalert.model.Firestation;
import com.safetynetalert.model.Person;
import com.safetynetalert.repository.FirestationRepository;
import com.safetynetalert.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FirestationService {
    @Autowired
    private FirestationRepository firestationRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private MedicalRecordService medicalRecordService;


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




    public List<PersonCoverByFirestation> findPersonsByStation(int station) {
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
}










  /*  public Firestation saveFirestation(Firestation firestation) {
        Firestation savedFirestation = firestationRepository.saveFirestation(firestation);

        return savedFirestation;
    }**/


