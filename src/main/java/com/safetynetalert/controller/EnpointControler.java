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
import org.tinylog.Logger;

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
    @GetMapping( "firestation/stationNumber")
    public List<StationNumber> findStationInfo(@RequestParam int station) {
        Logger.info("findStationInfo");
        return endPointService.findStationInfo(station);
}
    //checklist: url 2 childAlert
    @GetMapping( "childAlert")
    public List<ChildAlert> getChildAlert(@RequestParam String address) {
        Logger.info("getChildAlert");
        return endPointService.getChildAlert(address);
    }
    //checklist: url 3 phoneAlert
    //TODO: corriger le endpoint les numero de telephone d'une seul station sont affiché
    @GetMapping( "phoneAlert")
    public List<String> PhoneAlert(@RequestParam int station) {
        Logger.info("PhoneAlert");
        return endPointService.findPhoneAlert(station);
    }

    //checklist: url 4 fire
    @GetMapping("fire")
    public Fire getFire(@RequestParam String address) {
        Logger.info("getFire");
        return endPointService.getFire(address);
    }
    //checklist: url 5 flood/stations
    @GetMapping("flood/stations")
    public List<AllFamilyByStation> getFlood(@RequestParam List<Integer> stations) {
        Logger.info("getFlood");
        return endPointService.getFlood(stations);


    }
    //checklist: url 6 personInfo
    @GetMapping("personInfo")
    public List<PersonInfo> getPersonInfo(@RequestParam String firstName, @RequestParam String lastName) {
        Logger.info("getPersonInfo");
        return endPointService.getPersonInfo(firstName, lastName);
    }


    //checklist: url 7 communityEmail
    @GetMapping("communityEmail")
    public List<String> getCommunityEmail(@RequestParam String city) {
        Logger.info("getCommunityEmail");
        return endPointService.getCommunityEmail(city);
    }
}
