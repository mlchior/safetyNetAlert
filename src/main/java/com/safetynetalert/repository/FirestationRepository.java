package com.safetynetalert.repository;

import com.safetynetalert.model.Firestation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FirestationRepository {
    private static ArrayList<Firestation> firestationList = new ArrayList<>();

    public static void initFirestation() {
        Firestation firestation = new Firestation("saint ouen", 3);
        firestationList.add(firestation);
        firestation = new Firestation("Paris", 2);
        firestationList.add(firestation);
        firestationList.add(new Firestation("saint ouen", 4));
        firestationList.add(new Firestation("melbourne", 5));
        firestationList.add(new Firestation("montrouge", 8));

    }


    public List<Firestation> getAllFirestation() {
        return firestationList;
    }


    public Firestation addFirestation(Firestation firestation) {
        firestationList.add(firestation);
        return firestation;
    }

    public void deleteFirestation(String adress) {
        firestationList.removeIf(firestation -> firestation.getAdress().equals(adress));
    }


    public Firestation updateFirestation(Firestation firestation) {
        int index = firestationList.indexOf(firestation);
        firestationList.set(index, firestation);
        return firestation;
    }

}


