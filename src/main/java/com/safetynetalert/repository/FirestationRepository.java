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


    public static Firestation  getFirestationByStation(int station) {
        for (int i = 0; i < firestationList.size(); i++) {
            if (firestationList.get(i).getStation() == station) {
                return firestationList.get(i);
            }
        } return null;
    }

  /*  public Firestation saveFirestation(Firestation firestation) {
        firestationList.savedFirestation(firestation);
        return firestation;
    }**/

   public Firestation getFirestationByAddress(String address) {
        for (int i = 0; i < firestationList.size(); i++) {
            if (firestationList.get(i).getAdress().equals(address)) {
                return firestationList.get(i);
            }
        }
        return null;
}

    public List<Firestation> getAllFirestation() {
        return firestationList;
    }

    public void save(Firestation firestation) {
        firestationList.add(firestation);
    }
}

