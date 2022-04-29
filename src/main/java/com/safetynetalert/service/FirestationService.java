package com.safetynetalert.service;
import com.safetynetalert.model.Firestation;
import com.safetynetalert.repository.FirestationRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class FirestationService {

    private FirestationRepository firestationRepository;

    public Firestation getFirestationByStation(int station){
        return (firestationRepository.getFirestationByStation(station));
    }






  /*  public Firestation saveFirestation(Firestation firestation) {
        Firestation savedFirestation = firestationRepository.saveFirestation(firestation);

        return savedFirestation;
    }**/
}

