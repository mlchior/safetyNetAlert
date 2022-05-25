package com.safetynetalert.model;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class Firestation {

    private String adress;
    private int station;


    public Firestation(String adress, int station) {
        this.adress = adress;
        this.station = station;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getStation() {
        return station;
    }

    public void setStation(int station) {
        this.station = station;
    }



}
