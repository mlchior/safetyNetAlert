package com.safetynetalert.service;
import com.safetynetalert.model.Firestation;
import com.safetynetalert.repository.FirestationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirestationService {
    @Autowired
    private FirestationRepository firestationRepository;

    public Firestation findFirestationByStation(int station){
        return (firestationRepository.getFirestationByStation(station));
    }
    public Firestation findFirestationByAdress(String adress){
        return (firestationRepository.getFirestationByAddress(adress));
    }

    public List<Firestation> findAllFirestation() {
        return firestationRepository.getAllFirestation();
    }
    //TODO: Add a method to add a new firestation to firestationList
    public void addFirestation(Firestation firestation) {
        firestationRepository.save(firestation);
    }







  /*  public Firestation saveFirestation(Firestation firestation) {
        Firestation savedFirestation = firestationRepository.saveFirestation(firestation);

        return savedFirestation;
    }**/
}

