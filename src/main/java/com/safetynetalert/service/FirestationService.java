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









  /*  public Firestation saveFirestation(Firestation firestation) {
        Firestation savedFirestation = firestationRepository.saveFirestation(firestation);

        return savedFirestation;
    }**/
}

