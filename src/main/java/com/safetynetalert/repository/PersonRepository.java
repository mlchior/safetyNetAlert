package com.safetynetalert.repository;

import com.safetynetalert.model.Person;

import java.util.ArrayList;

public class PersonRepository {
    private static ArrayList<Person> personsList = new ArrayList<>();
    public static void initPersonList() {
        personsList.add(new Person("John", "Doe", "clef des champs", "Melbourne", "55555", "0634437847636", "boulou@gmail.com"));
       personsList.add( new Person("John", "Smith", "123 Main St.", "montrouge", "93400", "0634432234", "bilou@gmail.com"));
        personsList.add(new Person("andré", "tutu", "clef des champs", "paris", "75017", "0634437847636", "andre.tutu@gmail.com"));

}}
