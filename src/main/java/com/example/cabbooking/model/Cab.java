package com.example.cabbooking.model;

public class Cab {
    private int cabNumber;
    private int timeTaken;
    private Location pickupLocation = null;
    private Location destinationLocation = null;
    private boolean booked;

    public Cab(int cabNumber) {
        pickupLocation = new Location();
        destinationLocation = new Location();
        this.cabNumber =cabNumber;
        booked = false;
        timeTaken = 0;
    }

    public int getCabNumber() {
        return cabNumber;
    }

    public int gettimeTaken() {
        return timeTaken;
    }

    public void settimeTaken(int timeTaken) {
        this.timeTaken = timeTaken;
    }

    public void setPickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public void setDestinationLocation(Location destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    @Override
    public String toString() {
        return "Cab_" +
                "id:" +cabNumber +
                 ", pickupLocation: {x:" + pickupLocation.getX() + ",y: " + pickupLocation.getY() + "}" +
                ", destinationLocation: { x:" + destinationLocation.getX() + " , y:" + destinationLocation.getY() + "}" +
                ", booked:" + booked +
                ", timeTaken:" + timeTaken;
    }
}
