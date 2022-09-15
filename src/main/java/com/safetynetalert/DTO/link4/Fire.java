package com.safetynetalert.DTO.link4;

import com.safetynetalert.model.Firestation;

import java.util.List;

public class Fire {
    private List<PersonByAddress> personByAdress;
    private Firestation firestation;

    public Fire() {
    }

    public Fire(List<PersonByAddress> personByAdress, Firestation firestation) {
        this.personByAdress = personByAdress;
        this.firestation = firestation;
    }

    public List<PersonByAddress> getPersonByAdress() {
        return personByAdress;
    }

    public void setPersonByAdress(List<PersonByAddress> personByAdress) {
        this.personByAdress = personByAdress;
    }

    public Firestation getFirestation() {
        return firestation;
    }

    public void setFirestation(Firestation firestation) {
        this.firestation = firestation;
    }
}
