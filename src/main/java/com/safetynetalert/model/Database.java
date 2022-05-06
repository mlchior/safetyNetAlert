package com.safetynetalert.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class Database {
    private static List<Person> persons;

   // @PostConstruct to initialize the static variable persons and map the json file data.json to the list persons.
    @PostConstruct
    public void init() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        ObjectMapper mapper = new ObjectMapper();
         persons = new ArrayList<Person>();
        try {
            JSONObject object = (JSONObject) parser.parse(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("src/main/ressource/data.json")));
            JSONArray jsonArray = (JSONArray) object.get(persons);
            // iterer sur Array
            jsonArray.listIterator();
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
        /*for (int i = 0; i < firestationList.size(); i++) {
            if (firestationList.get(i).getAdress().equals(address)) {
                return firestationList.get(i);
            }**/
    }
     /*   persons = new ObjectMapper().readValue(new File("src/main/ressource/data.json"), List.class);
    }**/

    // Getter for the static variable persons.
    public static List<Person> getPersons() {
        return persons;
    }
}



