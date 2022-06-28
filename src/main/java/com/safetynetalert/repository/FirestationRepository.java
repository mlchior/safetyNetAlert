package com.safetynetalert.repository;
import com.safetynetalert.model.Database;
import com.safetynetalert.model.Firestation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FirestationRepository{
    private static ArrayList<Firestation> firestationList = new ArrayList<>();

    @Autowired
    private Database database;


    public static void initFirestation() {


    }


    public List<Firestation> getAllFirestation() {
        return database.getFirestations();
    }


    public Firestation addFirestation(Firestation firestation) {
        firestationList.add(firestation);
        return firestation;
    }

    public void deleteFirestation(String adress) {
        firestationList.removeIf(firestation -> firestation.getAddress().equals(adress));
    }


    public Firestation updateFirestation(Firestation firestation) {
        for (Firestation newFirestation : firestationList) {
            if (newFirestation.getAddress().equals(firestation.getAddress())) {
                newFirestation.setAddress(firestation.getAddress());
                newFirestation.setStation(firestation.getStation());
                return newFirestation;
            }
        }
        return null;
    }

    public Firestation getFirestationByAdress(int station) {
        for (Firestation firestation : firestationList) {
            if (firestation.getStation() == station) {
                return firestation;
            }
        }
        return null;
    }

    public Firestation getFirestationByAddress(String adress) {
        for (Firestation firestation : firestationList) {
            if (firestation.getAddress().equals(adress)) {
                return firestation;
            }
        }
        return null;
    }




// comparer dans ma liste de firestation et ma liste de Person. Si des adresses son commune alors on ajoute les personnes dans la liste de firestation
   /* public void addPerson(String adress, List<String> person) {
        for (Firestation firestation : firestationList) {
            if (firestation.getAdress().equals(adress)) {
                for (String person1 : person) {
                    firestation.getPerson().add(person1);
                }
            }
        }
    }
    public Firestation findFirestationByAdress(String adress) {
        for (Firestation firestation : firestationList) {
            if (firestation.getAdress().equals(adress)) {
                return firestation;
            }
        }
        return null;
    }**/
}



