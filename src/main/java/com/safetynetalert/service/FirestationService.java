package com.safetynetalert.service;
import com.safetynetalert.DTO.link1.PersonCoverByFirestation;
import com.safetynetalert.DTO.link1.StationNumber;
import com.safetynetalert.DTO.link3.PhoneAlert;
import com.safetynetalert.model.Firestation;
import com.safetynetalert.model.Medicalrecord;
import com.safetynetalert.model.Person;
import com.safetynetalert.repository.IFirestationRepository;
import com.safetynetalert.repository.IMedicalrecordRepository;
import com.safetynetalert.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tinylog.Logger;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;



@Service
public class FirestationService {
    @Autowired
    private IFirestationRepository iFirestationRepository;
    @Autowired
    private IPersonRepository iPersonRepository;
    @Autowired
    private IMedicalrecordRepository iMedicalrecordRepository;



    public List<Firestation> findAllFirestation() {
        Logger.info("findAllFirestation SUCCESS");
        return iFirestationRepository.getAll();
    }
    public Firestation addFirestation(Firestation firestation) {
        Logger.info("addFirestation SUCCESS" + firestation);
        return iFirestationRepository.addFirestation(firestation);
    }
    public Firestation updateFirestation(Firestation firestation) {
        Logger.info("updateFirestation SUCCESS" + firestation);
        return iFirestationRepository.updateFirestation(firestation);
    }
    public Firestation deleteFirestation(String address) {
        Logger.info("deleteFirestation SUCCESS" + address);
        return iFirestationRepository.deleteFirestation(address);
    }
    public List<Firestation> findAllFirestationByStation(int station) {
        Logger.info("findAllFirestationByStation SUCCESS" + station);
        return iFirestationRepository.findAllFirestationByStation(station);
    }
    public List<Firestation> findFirestationByAdress(String address) {
        Logger.info("findFirestationByAdress SUCCESS" + address);
        return iFirestationRepository.findFirestationByAdress(address);
    }
    public List<String> findAllAddressByStation(int station) {
        Logger.info("findAllAddressByStation SUCCESS" + station);
        return iFirestationRepository.findAllAddressByStation(station);
    }
}
