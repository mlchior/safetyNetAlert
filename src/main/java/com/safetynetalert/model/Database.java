package com.safetynetalert.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Component
public class Database {
    private static List<Person> persons;
    private static List<Firestation> firestations;
    private static List<MedicalRecord>      medicalRecords;


    private InputStreamReader getInputStreamReader() throws IOException{
        File file = new File("/Users/melchior/safetyNetAlert/src/main/resources/data.json");
        return new InputStreamReader(new FileInputStream(file));

    }

    // @PostConstruct to initialize the static variable persons and map the json file data.json to the list persons.
    @PostConstruct
    public void init() throws IOException{

        JSONParser parser = new JSONParser();
        ObjectMapper mapper = new ObjectMapper();
        persons = new ArrayList<>();
        firestations = new ArrayList<>();
        medicalRecords = new ArrayList<>();
        InputStreamReader inputStreamReader = getInputStreamReader();


        try {

            JSONObject object = (JSONObject) parser.parse(inputStreamReader);
            JSONArray jsonArray = (JSONArray) object.get("persons");
            ListIterator<JSONObject> listPersons = jsonArray.listIterator();
            while(listPersons.hasNext()){
                persons.add(mapper.readValue(listPersons.next().toString(), Person.class));
            }
        }catch(ParseException e)
            {e.printStackTrace();
        }
        for(int i =0; i<persons.size(); i++){
            System.out.println(persons.get(i).getFirstName());
        }

    }

    public static List<Person> getPersons() {
        return persons;
    }

    public static List<Firestation> getFirestations() {
        return firestations;
    }

    public static List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public static void setPersons(List<Person> persons) {
        Database.persons = persons;
    }

    public static void setFirestations(List<Firestation> firestations) {
        Database.firestations = firestations;
    }

    public static void setMedicalRecords(List<MedicalRecord> medicalRecords) {
        Database.medicalRecords = medicalRecords;
    }
}