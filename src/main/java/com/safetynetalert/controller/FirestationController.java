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
            Logger.error("getAllFirestation FAILED");
        }else {
            Logger.info("getAllFirestation SUCCESS");
        }
        return getAllFirestation;
    }

    @PostMapping("/firestation")
    public Firestation addFirestation(@RequestBody Firestation firestation){
        Firestation addFirestation = firestationService.addFirestation(firestation);
        if(addFirestation == null){
            Logger.error("addFirestation FAILED");
        }else{
            Logger.info("addFirestation SUCCESS");
        }
        return addFirestation;
    }
    @PutMapping("/firestation")
    public Firestation updateFirestation(@RequestBody Firestation firestation){
        Firestation updateFirestation = firestationService.updateFirestation(firestation);
        if(updateFirestation == null){
            Logger.error("updateFirestation FAILED");
        }else{
            Logger.info("updateFirestation SUCCESS");
        }
        return updateFirestation;

    }
    @DeleteMapping("/firestation")
    public Firestation deleteFirestation(@RequestParam String address){
        Firestation deleteFirestation = firestationService.deleteFirestation(address);
        if(deleteFirestation == null){
            Logger.error("deleteFirestation FAILED");
        }else{
            Logger.info("deleteFirestation SUCCESS");
        }
        return deleteFirestation;
    }
    @GetMapping("/firestationbyadress")
    public List<Firestation> findFirestationByAdress(@RequestParam String address){
        List<Firestation> deleteFirestation = firestationService.findFirestationByAdress(address);
        if(deleteFirestation == null){
            Logger.error("findFirestationByAdress FAILED");
        }else{
            Logger.info("findFirestationByAdress SUCCESS");
        }
        return deleteFirestation;
    }
    @GetMapping("stationList")
    public List<String> stationList(@RequestParam int station) {
        Logger.info("stationList SUCCESS");
        return firestationService.findAllAddressByStation(station);
    }
}


