package com.safetynetalert.service;
import com.safetynetalert.model.Firestation;
import com.safetynetalert.repository.FirestationRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirestationService {
    @Autowired
    private FirestationRepository firestationRepository;

    public Firestation getFirestationByStation(int station){
        return (firestationRepository.getFirestationByStation(station));
    }
    public Firestation getFirestationByAdress(String adress){
        return (firestationRepository.getFirestationByAddress(adress));
    }

    public List<Firestation> getAllFirestation() {
        return firestationRepository.findAll();
    }






  /*  public Firestation saveFirestation(Firestation firestation) {
        Firestation savedFirestation = firestationRepository.saveFirestation(firestation);

        return savedFirestation;
    }**/
}

