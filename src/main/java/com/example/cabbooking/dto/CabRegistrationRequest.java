package com.example.cabbooking.dto;

import com.example.cabbooking.model.Location;

public class CabRegistrationRequest {
    private String cabRegistrationNumber;
    private Location cabLocation;
    private String cabType;

    public CabRegistrationRequest(String cabRegistrationNumber, Location cabLocation, String cabType) {
        this.cabRegistrationNumber = cabRegistrationNumber;
        this.cabLocation = cabLocation;
        this.cabType = cabType;
    }

    public Location getCabLocation() {
        return cabLocation;
    }

    public String getCabType() {
        return cabType;
    }

    public String getCabRegistrationNumber() {
        return cabRegistrationNumber;
    }
}
