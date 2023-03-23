package com.safetynetalert.controller;
import com.safetynetalert.DTO.link1.StationNumber;
import com.safetynetalert.model.Firestation;
import com.safetynetalert.service.FirestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tinylog.Logger;

import java.util.List;

@RestController
public class FirestationController {
    @Autowired
    FirestationService firestationService;

    @GetMapping("/firestation")
    public List<Firestation>  getAllFirestation(){
        List<Firestation> getAllFirestation = firestationService.findAllFirestation();
        if(getAllFirestation == null) {
            Logger.error("getAllFirestation FAILED" + getAllFirestation);
        }else {
            Logger.info("getAllFirestation SUCCESS"+ getAllFirestation);
        }
        return getAllFirestation;
    }

    @PostMapping("/firestation")
    public Firestation addFirestation(@RequestBody Firestation firestation){
        Firestation addFirestation = firestationService.addFirestation(firestation);
        if(addFirestation == null){
            Logger.error("addFirestation FAILED" + firestation);
        }else{
            Logger.info("addFirestation SUCCESS" + firestation);
        }
        return addFirestation;
    }
    @PutMapping("/firestation")
    public Firestation updateFirestation(@RequestBody Firestation firestation){
        Firestation updateFirestation = firestationService.updateFirestation(firestation);
        if(updateFirestation == null){
            Logger.error("updateFirestation FAILED" + firestation);
        }else{
            Logger.info("updateFirestation SUCCESS" + firestation);
        }
        return updateFirestation;

    }
    @DeleteMapping("/firestation")
    public Firestation deleteFirestation(@RequestParam String address){
        Firestation deleteFirestation = firestationService.deleteFirestation(address);
        if(deleteFirestation == null){
            Logger.error("deleteFirestation FAILED" + address);
        }else{
            Logger.info("deleteFirestation SUCCESS"+ address);
        }
        return deleteFirestation;
    }
    @GetMapping("/firestationbyadress")
    public List<Firestation> findFirestationByAdress(@RequestParam String address){
        List<Firestation> deleteFirestation = firestationService.findFirestationByAdress(address);
        if(deleteFirestation == null){
            Logger.error("findFirestationByAdress FAILED" + address);
        }else{
            Logger.info("findFirestationByAdress SUCCESS"+ address);
        }
        return deleteFirestation;
    }
    @GetMapping("stationList")
    public List<String> stationList(@RequestParam int station) {
        List<String> stationList = firestationService.findAllAddressByStation(station);
        if (stationList == null) {
            Logger.error("stationList FAILED" + station);
        } else
        Logger.info("stationList SUCCESS" + station);
        return firestationService.findAllAddressByStation(station);
    }
}


