package com.example.cabbooking.controller;

import java.util.List;

import com.example.cabbooking.model.Cab;
import com.example.cabbooking.storage.CabStorage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cabs")
public class CabsController {
    @GetMapping("/")
    public ResponseEntity<List<Cab>> getCabDetails() {
        List<Cab> cabs = CabStorage.getInstance().getCabDetails();
        return ResponseEntity.ok(cabs);
    }
}
