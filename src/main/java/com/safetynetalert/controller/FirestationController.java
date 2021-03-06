package com.safetynetalert.controller;

import com.safetynetalert.model.Firestation;
import com.safetynetalert.service.FirestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FirestationController {
    @Autowired
    private FirestationService firestationService;



    //@GetMapping with Firestation int station
   @GetMapping("/firestation/{station}")
    public Firestation getFirestationByStation(@PathVariable int station) {
        return firestationService.getFirestationByStation(station);
    }
    @GetMapping("/firestation")
    public boolean test(){
        System.out.println("hello");
        return true;
    }
    // getAllFirestation method
    @GetMapping("/firestation/all")
    public List<Firestation> getAllFirestation() {
        return firestationService.getAllFirestation();
    }
    @GetMapping("/firestation/adress/{adress}")
    public Firestation getFirestationByAdress(@PathVariable("adress") String adress){
       return firestationService.getFirestationByAdress(adress);
    }
    @
}
