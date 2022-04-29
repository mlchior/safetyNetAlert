package com.safetynetalert.controller;

import com.safetynetalert.model.Firestation;
import com.safetynetalert.service.FirestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirestationController {
    @Autowired
    private FirestationService firestationService;



    //@GetMapping with Firestation int station
   @GetMapping("/firestation/{station}")
    public Firestation getFirestation(@PathVariable int station) {
        return firestationService.getFirestationByStation(station);
    }
    @GetMapping("/firestation")
    public boolean test(){
        System.out.println("hello");
        return true;
    }
    //PostMapping with Firestation firestation
   @PostMapping("/firestation")
    public Firestation addFirestation(@RequestBody Firestation firestation) {
        return firestationService.saveFirestation(firestation);
    }

}
