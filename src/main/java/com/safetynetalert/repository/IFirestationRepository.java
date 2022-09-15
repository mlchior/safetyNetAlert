package com.safetynetalert.repository;

import com.safetynetalert.model.Firestation;

import java.util.List;


public interface IFirestationRepository {


    List<Firestation> getAll();

    Firestation addFirestation(Firestation firestation);

    Firestation updateFirestation(Firestation firestation);

    Firestation deleteFirestation(String address);

    Firestation getFirestationByAdress(String address);

    Firestation getFirestationByStation(int station);
}


