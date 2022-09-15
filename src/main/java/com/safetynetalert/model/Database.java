package com.safetynetalert.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;
import org.tinylog.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Component
public class Database {
    private static List<Person> persons;
    private static List<Firestation> firestations;
    private static List<Medicalrecord> medicalrecords;


    private static InputStreamReader getInputStreamReader() {
        try {
            File file = new File("/Users/melchior/safetyNetAlert/src/main/resources/data.json");
            return new InputStreamReader(new FileInputStream(file));

        } catch (IOException e) {
            e.printStackTrace();
            Logger.error("Error while reading file");

        }
        return null;

    }

        // @PostConstruct to initialize the static variable persons and map the json file data.json to the list persons.

        // 3 fonction init pour chaque class.import init va appeler initPerson initFirestation et initMedicat


        public static void init() {

            JSONParser parser = new JSONParser();
            ObjectMapper mapper = new ObjectMapper();
            persons = new ArrayList<>();
            firestations = new ArrayList<>();
            medicalrecords = new ArrayList<>();
            InputStreamReader inputStreamReader = getInputStreamReader();


            try {
                JSONObject object = (JSONObject) parser.parse(inputStreamReader);
                JSONArray jsonArray = (JSONArray) object.get("persons");
                JSONArray jsonArray1 = (JSONArray) object.get("firestations");
                JSONArray jsonArray2 = (JSONArray) object.get("medicalrecords");
                ListIterator<JSONObject> listPersons = jsonArray.listIterator();
                ListIterator<JSONObject> listFirestations = jsonArray1.listIterator();
                ListIterator<JSONObject> listMedicalRecords = jsonArray2.listIterator();

                while (listPersons.hasNext()) {

                    persons.add(mapper.readValue(listPersons.next().toString(), Person.class));
                    if(persons.isEmpty()){
                        Logger.error("initPerson FAILED");
                    }else{
                        Logger.info("initPerson SUCCESS");
                    }
                }
                while (listFirestations.hasNext()) {
                    firestations.add(mapper.readValue(listFirestations.next().toString(), Firestation.class));
                    if(firestations.isEmpty()){
                        Logger.error("initFirestation FAILED");
                    }else{
                        Logger.info("initFirestation SUCCESS");
                    }
                }
                while (listMedicalRecords.hasNext()) {
                    medicalrecords.add(mapper.readValue(listMedicalRecords.next().toString(), Medicalrecord.class));
                    if(medicalrecords.isEmpty()){
                        Logger.error("initMedicalRecords is Empty");
                    }else{
                        Logger.info("initMedicalRecords SUCCESS");
                    }
                }

            } catch (ParseException | IOException e) {
                e.printStackTrace();
                Logger.error("Error while Mapping");
            }

        }
// passer initperson firestation en debug laisser initdabase en Info
    public static List<Person> getPersons() {
        if(persons == null)
            Database.init();

        return persons;
    }

    public static List<Firestation> getFirestations() {
        if(firestations == null)
            Database.init();

        return firestations;
    }

    public static List<Medicalrecord> getMedicalrecords() {
        if(medicalrecords == null)
            Database.init();
        return medicalrecords;
    }


    public static void setPersons(List<Person> persons) {
        Database.persons = persons;
    }

    public static void setFirestations(List<Firestation> firestations) {
        Database.firestations = firestations;
    }

    public static void setMedicalrecords(List<Medicalrecord> medicalrecords) {
        Database.medicalrecords = medicalrecords;
    }

}
