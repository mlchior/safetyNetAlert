package com.safetynetalert.controller;

import com.safetynetalert.DTO.link1.PersonCoverByFirestation;
import com.safetynetalert.DTO.link1.StationInfo;
import com.safetynetalert.model.Firestation;
import com.safetynetalert.service.FirestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FirestationController {
    @Autowired
    private FirestationService firestationService;



    //@GetMapping with Firestation int station


    // getAllFirestation method
    @GetMapping("/firestation")
    public List<Firestation> getAllFirestation() {
        return firestationService.findAllFirestation();
    }
    @PostMapping("/firestation")
    public Firestation addFirestation(@RequestBody Firestation firestation) {
        return firestationService.addFirestation(firestation);
    }
    @DeleteMapping("/firestation")
    public void deleteFirestation(@RequestParam String adress) {
        firestationService.deleteFirestation(adress);
    }
    @PutMapping("/firestation")
    public Firestation updateFirestation(@RequestBody Firestation firestation) {
        return firestationService.updateFirestation(firestation);
    }
   /****/
    //return List<fire>
    @GetMapping("/firestation/station/stationinfo")
    public List<StationInfo> findStationInfo(@RequestParam int station) {
        return firestationService.findStationInfo(station);
    }
    @GetMapping("/firestation/phonenumberbystation")
    public List<String> phoneAlert (@RequestParam int station) {
        return firestationService.findPhoneAlert(station);
    }
}





