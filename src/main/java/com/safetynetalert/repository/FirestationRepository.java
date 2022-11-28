package com.safetynetalert.repository;
import com.safetynetalert.model.Database;
import com.safetynetalert.model.Firestation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class FirestationRepository implements IFirestationRepository{

   public FirestationRepository(){
        firestations = Database.getFirestations();
   }


    static List<Firestation> firestations;
    @Override
    public List<Firestation> getAll() {
        return firestations;
    }

    @Override
    public Firestation addFirestation(Firestation firestation) {
        firestations.add(firestation);
        return firestation;
    }

    @Override
    public Firestation updateFirestation(Firestation firestation) {
      for (Firestation firestationToUpdate : firestations){
          if (firestationToUpdate.getAddress().equals(firestation.getAddress())){
              firestationToUpdate.setAddress(firestation.getAddress());
              firestationToUpdate.setStation(firestation.getStation());
              return firestationToUpdate;
          }
      }
      return null;
    }



    @Override
    public Firestation deleteFirestation(String address) {
        for (Firestation firestation : firestations) {
            if (firestation.getAddress().equals(address)) {
                firestations.remove(firestation);
                return firestation;
            }

        }
        return null;
    }


    public Firestation getFirestationByAdress(String address) {
        for (Firestation firestation : firestations) {
            if (firestation.getAddress().equals(address)) {
                return firestation;
            }
        }
        return null;
    }
    public Firestation getFirestationByStation(int station) {

        for (Firestation firestation : firestations) {
            if (firestation.getStation() == station) {
                return firestation;
            }
        }
        return null;
    }

    @Override
    public List<Firestation> findAllFirestationByStation(int station) {
        List<Firestation> firestationByStation = new ArrayList<>();
        for (Firestation firestation : firestations) {
            if (firestation.getStation() == station) {
                firestationByStation.add(firestation);
            }
        }
        return firestationByStation;
    }


    @Override
    public List<Firestation> findFirestationByAdress(String address) {
        List<Firestation> firestationByAddress = new ArrayList<>();
        for (Firestation firestation : firestations) {
            if (firestation.getAddress().equals(address)) {
                firestationByAddress.add(firestation);
            }
        }
        return firestationByAddress;
    }

    @Override
    public List<String> findAllAddressByStation(int station) {
        List<String> firestationByStationList = new ArrayList<>();
        for (Firestation firestation : firestations) {
            if (firestation.getStation() == station) {
                firestationByStationList.add(firestation.getAddress());
            }
        }
        return firestationByStationList;
    }

    /**
    public List<Firestation> findAllFirestationByStation2(List<Integer> station) {
        for (Firestation firestation : firestations) {
            if (firestation.getStation().equals(station){
                return firestations;
            }
        }
    }*/

    public List<Firestation> getStationInfo(int station) {

        for (Firestation firestation : firestations) {
            if (firestation.getStation() == station) {
                return firestations;
            }
        }
        return null;
    }



}


