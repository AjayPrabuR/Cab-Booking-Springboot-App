package com.example.cabbooking.model;

public class Cab {
    private int cabNumber;
    private int time;
    private Location pickupLocation = null;
    private Location destinationLocation = null;
    private boolean booked;

    public Cab(int cabNumber) {
        pickupLocation = new Location();
        destinationLocation = new Location();
        this.cabNumber =cabNumber;
        booked = false;
        time = 0;
    }

    public int getId() {
        return cabNumber;
    }

    public void setId(int cabNumber) {
        this.cabNumber =cabNumber;
    }

    public int gettime() {
        return time;
    }

    public void settime(int time) {
        this.time = time;
    }
    
    public Location getpickupLocation() {
        return pickupLocation;
    }

    public void setpickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public Location getDestinationLocation() {
        return destinationLocation;
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
        return "Cab:{" +
                "id:" +cabNumber +
                 ", pickupLocation: {x:" + pickupLocation.getX() + ",y: " + pickupLocation.getY() + "}" +
                ", destinationLocation: { x:" + destinationLocation.getX() + " , y:" + destinationLocation.getY() + "}" +
                ", booked:" + booked +
                ", bookedTime:" + time +
                '}';
    }
}
