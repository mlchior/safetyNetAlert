package com.safetynetalert.controller;

import com.safetynetalert.DTO.link1.PersonCoverByFirestation;
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
    @GetMapping("/firestation/station")
    public List<PersonCoverByFirestation> PersonByFirestation(@RequestParam int station) {
        return firestationService.findPersonsByStation(station);
    }
    //return List<fire>

}





