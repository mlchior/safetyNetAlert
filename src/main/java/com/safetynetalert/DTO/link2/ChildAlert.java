package com.safetynetalert.DTO.link2;

import java.util.List;

public class ChildAlert {
    private List<AgeOfPersons> child;
    private List<AgeOfPersons> adult;

    public List<AgeOfPersons> getChild() {
        return child;
    }

    public void setChild(List<AgeOfPersons> child) {
        this.child = child;
    }

    public List<AgeOfPersons> getAdult() {
        return adult;
    }

    public void setAdult(List<AgeOfPersons> adult) {
        this.adult = adult;
    }

}
