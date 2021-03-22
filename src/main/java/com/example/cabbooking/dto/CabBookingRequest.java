package com.example.cabbooking.dto;

import com.example.cabbooking.model.Location;

public class CabBookingRequest {
    String cabType;
    Location pickupLocation;
    Location destinationLocation;

    public CabBookingRequest(String cabType, Location pickupLocation, Location destinationLocation) {
        this.cabType = cabType;
        this.pickupLocation = pickupLocation;
        this.destinationLocation = destinationLocation;
    }

    public String getCabType() {
        return cabType;
    }

    public Location getPickupLocation() {
        return pickupLocation;
    }

    public Location getDestinationLocation() {
        return destinationLocation;
    }
}
