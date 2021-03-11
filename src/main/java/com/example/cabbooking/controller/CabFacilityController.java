package com.example.cabbooking.controller;

import com.example.cabbooking.model.Cab;
import com.example.cabbooking.model.Location;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cab")
public class CabFacilityController {
    private Cab[] cabs = null;

    private int getDistanceTravelled(Location pickupLocation, Location destinationLocation) {
        int distanceTravelled = (int)Math.sqrt((destinationLocation.getX() - pickupLocation.getX()) * (destinationLocation.getX() - pickupLocation.getX())  +  (destinationLocation.getY() - pickupLocation.getY()) * (destinationLocation.getY() - pickupLocation.getY()));
        return distanceTravelled;
    }

    @PutMapping("/register")
    public ResponseEntity<String> register() {
        cabs = new Cab[5];
        for (int i = 0; i < cabs.length; i++) {
            cabs[i] = new Cab(i + 1);
        }

        if (cabs == null) return new ResponseEntity(HttpStatus.BAD_REQUEST);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        if (cabs == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        StringBuilder buildResponse = new StringBuilder();
        for (Cab cab : cabs) {
            buildResponse.append(cab.toString()+"\n");
        }
        return new ResponseEntity(buildResponse.toString(), HttpStatus.OK);
    }
}
