package com.safetynetalert.controller;

import com.safetynetalert.DTO.PersonInfo;
import com.safetynetalert.DTO.link5.AllFamilyByStation;
import com.safetynetalert.DTO.link1.StationNumber;
import com.safetynetalert.DTO.link2.ChildAlert;
import com.safetynetalert.DTO.link4.Fire;
import com.safetynetalert.service.EndPointService;
import com.safetynetalert.service.FirestationService;
import com.safetynetalert.service.MedicalRecordService;
import com.safetynetalert.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EnpointControler {
    @Autowired
    FirestationService firestationService;
    @Autowired
    PersonService personService;
    @Autowired
    MedicalRecordService medicalRecordService;
    @Autowired
    EndPointService endPointService;



    //TODO: add all the endpoints
    //checklist: url 1 firestation
    @GetMapping( "firestation/stationNumberz")
    public List<StationNumber> findStationInfo(@RequestParam int station) {
        return endPointService.findStationInfo(station);
}
    //checklist: url 2 childAlert
    @GetMapping( "childAlert")
    public List<ChildAlert> getChildAlert(@RequestParam String address) {
        return endPointService.getChildAlert(address);
    }
    //checklist: url 3 phoneAlert
    //TODO: corriger le endpoint les numero de telephone d'une seul station sont affiché
    @GetMapping( "phoneAlertz")
    public List<String> PhoneAlert(@RequestBody int station) {
        return endPointService.findPhoneAlert(station);
    }

    //checklist: url 4 fire
    @GetMapping("fire")
    public Fire getFire(@RequestParam String address) {
        return endPointService.getFire(address);
    }
    //checklist: url 5 flood/stations
    @GetMapping("flood/stationsz")
    public List<AllFamilyByStation> getFlood(@RequestParam List<Integer> stations) {
        System.out.println("stations = " + stations.get(0));
        return endPointService.getFlood(stations);


    }
    //checklist: url 6 personInfo
    @GetMapping("personInfoz")
    public List<PersonInfo> getPersonInfo(@RequestParam String firstName, @RequestParam String lastName) {
        return endPointService.getPersonInfo(firstName, lastName);
    }


    //checklist: url 7 communityEmail
    public List<String> getCommunityEmail(@RequestParam String city) {
        return endPointService.getCommunityEmail(city);
    }

}
