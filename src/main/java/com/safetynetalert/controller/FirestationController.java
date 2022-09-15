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
    private FirestationService firestationService;

    @GetMapping("/firestation")
    public List<Firestation>  getAllFirestation(){
        List<Firestation> f = firestationService.findAllFirestation();
        if (f == null) {
            Logger.error("getAllFirestation FAILED");
        }else {
            Logger.info("getAllFirestation SUCCESS");
        }
        return f;
    }

    @PostMapping("/firestation")
    public Firestation addFirestation(@RequestBody Firestation firestation){
        Firestation f = firestationService.addFirestation(firestation);
        if(f == null){
            Logger.error("addFirestation FAILED");
        }else{
            Logger.info("addFirestation SUCCESS");
        }
        return f;
    }
    @PutMapping("/firestation")
    public Firestation updateFirestation(@RequestBody Firestation firestation){
        Firestation f = firestationService.updateFirestation(firestation);
        if(f == null){
            Logger.error("updateFirestation FAILED");
        }else{
            Logger.info("updateFirestation SUCCESS");
        }
        return f;

    }
    @DeleteMapping("/firestation")
    public Firestation deleteFirestation(@RequestParam String address){
        Firestation f = firestationService.deleteFirestation(address);
        if(f == null){
            Logger.error("deleteFirestation FAILED");
        }else{
            Logger.info("deleteFirestation SUCCESS");
        }
        return f;
    }
/*****************************************/
    @GetMapping("firestation/stationNumber")
    public List<StationNumber> findStationInfo(@RequestParam int station) {
        return firestationService.findStationInfo(station);
    }
    @GetMapping("firestation/phonenumberbystation")
    public List<String>  phoneAlert (@RequestParam int station) {
        return firestationService.findPhoneAlert(station);
    }
    @GetMapping("firestation/firestationbystation")

    public List<Firestation>  firestationByStation (@RequestParam int station) {
        return firestationService.findAllFirestationByStation(station);
    }


}


