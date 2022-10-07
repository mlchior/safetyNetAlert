package com.safetynetalert.DTO.link2;

import java.util.List;

public class ChildAlert {


    private String firstName;
    private String lastName;
    private int age;
    private List<AgeOfPersons> PersonWithChild;


    public ChildAlert(String firstName, String lastName, int age, List<AgeOfPersons> personWithChild) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        PersonWithChild = personWithChild;
    }

    public String getFirstName() {
        return firstName;
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

    public List<AgeOfPersons> getPersonWithChild() {
        return PersonWithChild;
    }

    public void setPersonWithChild(List<AgeOfPersons> personWithChild) {
        PersonWithChild = personWithChild;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public ChildAlert() {

    }

}

// recuperer toute les personnes par adress si - 18
// j'ajoute a une list child alert qui contien les information de chaque nefant + une copie de lia liste de chaque foyer