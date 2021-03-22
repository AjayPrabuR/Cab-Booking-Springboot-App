package com.example.cabbooking.controller;

import com.example.cabbooking.dto.CabBookingRequest;
import com.example.cabbooking.dto.CabRegistrationRequest;
import com.example.cabbooking.model.Cab;
import com.example.cabbooking.model.Location;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("cab")
public class CabFacilityController {
    private Map<String, Cab> cabs;

    public CabFacilityController() {
        this.cabs = new HashMap<>();
    }

    private float getAbsoluteDistance(Location location1, Location location2) {
        float absoluteDistance = (float) Math.sqrt((location2.getX() - location1.getX()) * (location2.getX() - location1.getX()) + (location2.getY() - location1.getY()) * (location2.getY() - location1.getY()));
        return absoluteDistance;
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody CabRegistrationRequest request) {
        String cabRegistrationNumber = request.getCabRegistrationNumber();
        if (cabs.containsKey(cabRegistrationNumber)) {
            return ResponseEntity.ok("Cab already registered!!!");
        }
        Cab cab = new Cab(cabRegistrationNumber, request.getCabLocation(), request.getCabType());
        cabs.put(cabRegistrationNumber, cab);
        return ResponseEntity.ok("Cab registered successfully!!!");
    }

    @GetMapping("/status")
    public ResponseEntity<Object> status() {
        return new ResponseEntity(cabs.values(), HttpStatus.OK);
    }

    @PutMapping("/book")
    public ResponseEntity<String> book(@RequestBody CabBookingRequest request) {
        float minimumDistanceBetweenCabAndUser = Float.MAX_VALUE;
        Cab bestMatchingCab = null;
        for (String cabRegistrationNumber : cabs.keySet()) {
            Cab cab = cabs.get(cabRegistrationNumber);
            if (cab.getCabType().equals(request.getCabType()) && !cab.getAvailability()) {
                float distanceBetweenCabAndUser = getAbsoluteDistance(request.getPickupLocation(), cab.getCabLocation());
                if (distanceBetweenCabAndUser < minimumDistanceBetweenCabAndUser) {
                    bestMatchingCab = cab;
                    minimumDistanceBetweenCabAndUser = distanceBetweenCabAndUser;
                }
            }
        }


        if (bestMatchingCab == null) {
            return new ResponseEntity("No cab available at the moment", HttpStatus.NOT_FOUND);
        }
        bestMatchingCab.book(request.getPickupLocation(), request.getDestinationLocation());
        return ResponseEntity.ok("Booking Successful!!!");
    }

}
