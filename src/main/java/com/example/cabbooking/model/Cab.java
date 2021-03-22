package com.example.cabbooking.model;

public class Cab {
    private String cabRegistrationNumber;
    private int timeTaken;
    private String cabType;
    private Location cabLocation = null;
    private Location pickupLocation = null;
    private Location destinationLocation = null;
    private boolean booked;

    public Cab(String cabRegistrationNumber, Location cablocation, String cabType) {
        this.cabLocation  = cablocation;
        this.pickupLocation = null;
        this.destinationLocation = null;
        this.cabType = cabType;
        this.cabRegistrationNumber = cabRegistrationNumber;
        this.booked = false;
        this.timeTaken = 0;
    }

    public String getCabRegistrationNumber() {
        return cabRegistrationNumber;
    }

    public int getTimeTaken() {
        return timeTaken;
    }

    public String getCabType() {
        return cabType;
    }

    public Location getCabLocation() {
        return cabLocation;
    }

    public Location getPickupLocation() {
        return pickupLocation;
    }

    public Location getDestinationLocation() {
        return destinationLocation;
    }

    public void setTimeTaken(int timeTaken) {
        this.timeTaken = timeTaken;
    }

    public boolean getAvailability() {
        return booked;
    }

    public void book(Location pickupLocation, Location destinationLocation)
    {
        this.booked = true;
        this.pickupLocation = pickupLocation;
        this.destinationLocation = destinationLocation;
    }

}
