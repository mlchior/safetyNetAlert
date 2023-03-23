package com.safetynetalert.DTO.link2;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AgeOfPersons {
    private String firstName;
    private String lastName;
    private int age;


    public AgeOfPersons() {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }
}
// recuperer la liste de toute les personne qui habite a cette adress
// parcours toute les personnes qui sont dans cette liste si <18 ou =
// si une personne rempli cette condition je peux arreter le parcours et return ma liste si je ne trouve personne je renvoi une liste vide
//

//

