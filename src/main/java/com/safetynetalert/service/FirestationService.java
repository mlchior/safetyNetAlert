package com.safetynetalert.service;
import com.safetynetalert.model.Firestation;
import com.safetynetalert.model.Person;
import com.safetynetalert.repository.FirestationRepository;
import com.safetynetalert.repository.MedicalRecordRepository;
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

    public List<Person> findPersonByStation(int station) {
        List<Person> personList = new ArrayList<>();
        String adressStation = firestationRepository.getFirestationByAdress(station).getAdress();

        for(Person person : personRepository.getAll()){
            if(person.getAdress().equals(adressStation)){
                personList.add(person);

            }
        }
        return personList;

    }


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


