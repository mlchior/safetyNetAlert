package com.safetynetalert.DTO.link4;

import com.safetynetalert.model.Firestation;

import java.util.List;

public class Fire {
    private List<PersonByAddress> personByAdress;
    private int station;

    public Fire() {
    }

    public Fire(List<PersonByAddress> personByAdress, Integer station) {
        this.personByAdress = personByAdress;
        this.station = station;
    }

    public List<PersonByAddress> getPersonByAdress() {
        return personByAdress;
    }

    public void setPersonByAdress(List<PersonByAddress> personByAdress) {
        this.personByAdress = personByAdress;
    }

    public int getStation() {
        return station;
    }

    public void setStation(int station) {
        this.station = station;
    }

    public void setStation(List<Firestation> firestationByAdress) {
        for (Firestation firestation : firestationByAdress) {
            this.station = firestation.getStation();
        }
     }
    }


