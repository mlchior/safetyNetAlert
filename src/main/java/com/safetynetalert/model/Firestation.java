package com.safetynetalert.model;

import lombok.Data;

@Data
public class Firestation {

    private String address;
    private int station;


    public Firestation(String adress, int station) {
        this.address = adress;
        this.station = station;
    }
    public Firestation(){}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStation() {
        return station;
    }

    public void setStation(int station) {
        this.station = station;
    }



}
