package com.example.cabbooking.model;

public class Cab {
    private String cabRegistrationNumber;
    private String cabType;
    private Location cabLocation = null;

    public Cab(String cabRegistrationNumber, Location cablocation, String cabType) {
        this.cabLocation  = cablocation;
        this.cabType = cabType;
        this.cabRegistrationNumber = cabRegistrationNumber;
    }

    public String getCabRegistrationNumber() {
        return cabRegistrationNumber;
    }

    public String getCabType() {
        return cabType;
    }

    public Location getCabLocation() {
        return cabLocation;
    }

}
