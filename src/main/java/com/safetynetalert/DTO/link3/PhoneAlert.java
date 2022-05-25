package com.safetynetalert.DTO.link3;

import java.util.List;

public class PhoneAlert {
    private List<String> phoneAlert;

    public PhoneAlert(List<String> phoneAlert) {
        this.phoneAlert = phoneAlert;
    }

    public List<String> getPhoneAlert() {
        return phoneAlert;
    }

    public void setPhoneAlert(List<String> phoneAlert) {
        this.phoneAlert = phoneAlert;
    }
}

