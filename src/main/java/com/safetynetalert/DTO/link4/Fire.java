package com.safetynetalert.DTO.link4;

import com.safetynetalert.model.Firestation;

import java.util.List;

public class Fire {
    private List<PersonByAdress> personByAdress;
    private Firestation firestation;

    public Fire() {
    }

    public Fire(List<PersonByAdress> personByAdress, Firestation firestation) {
        this.personByAdress = personByAdress;
        this.firestation = firestation;
    }

    public List<PersonByAdress> getPersonByAdress() {
        return personByAdress;
    }

    public void setPersonByAdress(List<PersonByAdress> personByAdress) {
        this.personByAdress = personByAdress;
    }

    public Firestation getFirestation() {
        return firestation;
    }

    public void setFirestation(Firestation firestation) {
        this.firestation = firestation;
    }
}
