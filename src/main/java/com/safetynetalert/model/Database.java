package com.safetynetalert.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
public class Database {
    private static List<Person> person;

   // @PostConstruct to initialize the static variable persons and map the json file data.json to the list persons.
    @PostConstruct
    public static void init() throws IOException {
        person = new ObjectMapper().readValue(Files.readAllBytes(Paths.get("data.json")), List.class);
    }

    // Getter for the static variable persons.
    public static List<Person> getPersons() {
        return person;
    }
}



