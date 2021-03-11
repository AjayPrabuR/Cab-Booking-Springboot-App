package com.example.cabbooking.controller;

import com.example.cabbooking.model.Cab;
import com.example.cabbooking.model.Location;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @PutMapping("/book/")
    public ResponseEntity<String> book(@RequestBody Map<String, Location> booking) {
        if (cabs == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        Location customerPickupLocation = booking.get("pickupLocation");
        Location customerDropLocation = booking.get("destinationLocation");
        String bill= "";
        int nextCabAvailable = -1;
        for (int i = 0; i < cabs.length; i++) {
            if (!cabs[i].isBooked()) {
                {
                    nextCabAvailable = i;
                    break;
                }
            }
        }


        if (nextCabAvailable != -1) {
            cabs[nextCabAvailable].setBooked(true);
            cabs[nextCabAvailable].settimeTaken(getDistanceTravelled(customerPickupLocation, customerDropLocation));
            cabs[nextCabAvailable].setPickupLocation(customerPickupLocation);
            cabs[nextCabAvailable].setDestinationLocation(customerDropLocation);
            bill=  "Cab_number " + String.valueOf(cabs[nextCabAvailable].getCabNumber()) + ",\nTime Taken: " + String.valueOf(cabs[nextCabAvailable].gettimeTaken()) +  ",\nFair: " + cabs[nextCabAvailable].gettimeTaken() * 5  +"\n";
            return new ResponseEntity(bill, HttpStatus.OK);
        }

        return new ResponseEntity(bill, HttpStatus.OK);
    }

}
