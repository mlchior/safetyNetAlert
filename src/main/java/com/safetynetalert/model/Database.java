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
    private static List<Person> persons;

    @PostConstruct
    public static void initDb() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        persons = mapper.readValue(Files.readAllBytes(Paths.get("src/main/resources/persons.json")),
                mapper.getTypeFactory().constructCollectionType(List.class, Person.class));

    }

    public static List<Person> getPersons() {
        return persons;
    }
}




   /** @PostConstruct
    public void init() throws IOException {
        Database db = new Database();
        byte[] dataJson = Files.readAllBytes(Paths.get("src/main/resources/Data.json"));

        ObjectMapper om  = new ObjectMapper();
        try {
            db = om.readValue(dataJson, Database.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}*/
