package com.safetynetalert.repository;
import com.safetynetalert.model.Database;
import com.safetynetalert.model.Firestation;
import org.springframework.stereotype.Repository;
import java.util.List;


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






}


