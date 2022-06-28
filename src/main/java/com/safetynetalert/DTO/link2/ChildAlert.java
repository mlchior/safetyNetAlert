package com.safetynetalert.DTO.link2;

import com.safetynetalert.model.Person;

import java.util.List;

public class ChildAlert {
    private String firstName;
    private String lastName;
    private String age;
    private List<Person> PersonWithChild;
}
// recuperer toute les personnes par adress si - 18
// j'ajoute a une list child alert qui contien les information de chaque nefant + une copie de lia liste de chaque foyer