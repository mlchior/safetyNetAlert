package com.safetynetalert.DTO.link3;

import java.util.List;

public class PhoneAlert {
    private List<String> phoneAlertList;

    public PhoneAlert(List<String> phoneAlert) {
        this.phoneAlertList = phoneAlert;
    }

    public List<String> getPhoneAlert() {
        return phoneAlertList;
    }

    public void setPhoneAlert(List<String> phoneAlert) {
        this.phoneAlertList = phoneAlert;
    }
}

