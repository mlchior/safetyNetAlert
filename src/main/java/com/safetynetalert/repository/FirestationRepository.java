package com.safetynetalert.repository;
import com.safetynetalert.DTO.link1.StationInfo;
import com.safetynetalert.DTO.link1.PersonCoverByFirestation;
import com.safetynetalert.model.Firestation;
import com.safetynetalert.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FirestationRepository implements IFirestationRepository{
    private static ArrayList<Firestation> firestationList = new ArrayList<>();

    public static void initFirestation() {

        Firestation firestation = new Firestation("21 jump street", 3);
        firestationList.add(firestation);
        firestation = new Firestation("Paris", 2);
        firestationList.add(firestation);
        firestationList.add(new Firestation("saint ouen", 4));
        firestationList.add(new Firestation("melbourne", 5));
        firestationList.add(new Firestation("montrouge", 8));
        firestationList.add(new Firestation("paris", 1));
        firestationList.add(new Firestation("london", 1));
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
        for (Firestation newFirestation : firestationList) {
            if (newFirestation.getAdress().equals(firestation.getAdress())) {
                newFirestation.setAdress(firestation.getAdress());
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
            if (firestation.getAdress().equals(adress)) {
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



