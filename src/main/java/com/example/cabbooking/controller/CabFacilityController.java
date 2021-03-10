package com.example.cabbooking.controller;

import com.example.cabbooking.model.Cab;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cab")
public class CabFacilityController {
    private Cab[] cars = null;

    @PutMapping("/register")
    public ResponseEntity<String> register() {
        cars = new Cab[5];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Cab(i + 1);
        }

        if (cars == null) return new ResponseEntity(HttpStatus.BAD_REQUEST);

        return new ResponseEntity(HttpStatus.OK);
    }
}
