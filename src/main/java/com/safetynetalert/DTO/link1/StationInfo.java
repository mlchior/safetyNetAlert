package com.safetynetalert.DTO.link1;

import com.safetynetalert.DTO.link1.PersonCoverByFirestation;

import java.util.List;

public class StationInfo {
    private List<PersonCoverByFirestation> ListPersonCoverByStation;
    private int numberOfAdult;
    private int numberOfChild;


    public StationInfo(List<PersonCoverByFirestation> listPersonCoverByStation, int numberOfAdult, int numberOfChild) {
        this.ListPersonCoverByStation = listPersonCoverByStation;
        this.numberOfAdult = numberOfAdult;
        this.numberOfChild = numberOfChild;
    }

    public List<PersonCoverByFirestation> getListPersonCoverByStation() {
        return ListPersonCoverByStation;
    }

    public void setListPersonCoverByStation(List<PersonCoverByFirestation> listPersonCoverByStation) {
        ListPersonCoverByStation = listPersonCoverByStation;
    }

    public int getNumberOfAdult() {
        return numberOfAdult;
    }

    public void setNumberOfAdult(int numberOfAdult) {
        this.numberOfAdult = numberOfAdult;
    }

    public int getNumberOfChild() {
        return numberOfChild;
    }

    public void setNumberOfChild(int numberOfChild) {
        this.numberOfChild = numberOfChild;
    }


}
