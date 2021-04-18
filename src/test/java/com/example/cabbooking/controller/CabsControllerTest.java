package com.example.cabbooking.controller;

import com.example.cabbooking.model.Cab;
import com.example.cabbooking.model.Location;
import com.example.cabbooking.storage.CabStorage;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
class CabFacilityControllerTest {

    @MockBean
    private CabsController cabsController;

    @Test
    public void shouldReturn200WhenBookingACabAfterRegistering() {
        List<Cab> cabDetails = new ArrayList<>();
        cabDetails.add(new Cab("TN57AF7676",new Location(4,5),"Small"));
        cabDetails.add(new Cab("TN57AF7677",new Location(5,6),"Large"));
        cabDetails.add(new Cab("TN57AF7678",new Location(6,7),"Medium"));
        cabDetails.add(new Cab("TN57AF7679",new Location(7,8),"Small"));
        cabDetails.add(new Cab("TN57AF7680",new Location(8,9),"Medium"));
        ResponseEntity<List<Cab>> response = ResponseEntity.ok(cabDetails);
        when(cabsController.getCabDetails()).thenReturn(response);
    }

}