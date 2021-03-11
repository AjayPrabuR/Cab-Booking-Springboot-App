package com.example.cabbooking.controller;

import com.example.cabbooking.model.Cab;
import com.example.cabbooking.model.Location;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("cab")
public class CabFacilityController {
    private List<Cab> cabs ;
    public CabFacilityController() {
        this.cabs = new ArrayList<>();
    }

    private int getDistanceTravelled(Location pickupLocation, Location destinationLocation) {
        int distanceTravelled = (int)Math.sqrt((destinationLocation.getX() - pickupLocation.getX()) * (destinationLocation.getX() - pickupLocation.getX())  +  (destinationLocation.getY() - pickupLocation.getY()) * (destinationLocation.getY() - pickupLocation.getY()));
        return distanceTravelled;
    }

    @PostMapping("/register/{cabType}")
    public ResponseEntity register(@PathVariable String cabType) {
        int cabRegisterNumber = cabs.size() + 1;
        cabs.add(new Cab(cabRegisterNumber));
       // System.out.print(cabType);
        return ResponseEntity.ok(cabRegisterNumber);
    }

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        StringBuilder buildResponse = new StringBuilder();
        for (Cab cab : cabs) {
            buildResponse.append(cab.toString()+"\n");
        }
        return new ResponseEntity(buildResponse.toString(), HttpStatus.OK);
    }

    @PutMapping("/book")
    public ResponseEntity<String> book(@RequestBody Map<String, Location> booking) {
        //System.out.print(">>>>>>"+cabs.size()+">>>>>>>\n");
        Location customerPickupLocation = booking.get("pickupLocation");
        Location customerDropLocation = booking.get("destinationLocation");
        String bill= "";
        int nextCabAvailable = -1;
        for (int i = 0; i < cabs.size(); i++) {
            if (!cabs.get(i).isBooked()) {
                {
                    nextCabAvailable = i;
                    break;
                }
            }
        }


        if (nextCabAvailable != -1) {
            cabs.get(nextCabAvailable).setBooked(true);
            cabs.get(nextCabAvailable).settimeTaken(getDistanceTravelled(customerPickupLocation, customerDropLocation));
            cabs.get(nextCabAvailable).setPickupLocation(customerPickupLocation);
            cabs.get(nextCabAvailable).setDestinationLocation(customerDropLocation);
            bill=  "Cab_number " + String.valueOf(cabs.get(nextCabAvailable).getCabNumber()) + ",\nTime Taken: " + String.valueOf(cabs.get(nextCabAvailable).gettimeTaken()) +  ",\nFair: " + cabs.get(nextCabAvailable).gettimeTaken() * 5  +"\n";
            return new ResponseEntity(bill, HttpStatus.OK);
        }

        return new ResponseEntity(bill, HttpStatus.NOT_FOUND);
    }

}
