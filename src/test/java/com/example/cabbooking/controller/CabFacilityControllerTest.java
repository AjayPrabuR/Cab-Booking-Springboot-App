package com.example.cabbooking.controller;

import com.example.cabbooking.model.Location;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.HashMap;
import java.util.Map;
import static org.mockito.Mockito.when;



@RunWith(SpringRunner.class)
@WebMvcTest(CabFacilityController.class)
class CabFacilityControllerTest {

    @MockBean
    private CabFacilityController cabFacilityController;

    @Test
    public void shouldReturn200AndCabRegisterNumberWhenRegisteringACab() {
        ResponseEntity response = ResponseEntity.ok(1);
        when(cabFacilityController.register("small")).thenReturn(response);
    }

    @Test
    public void shouldReturn200WhenCabsAreRegistered() {
        cabFacilityController.register("small");
        ResponseEntity response = new ResponseEntity(HttpStatus.OK);
        when(cabFacilityController.status()).thenReturn(response);
    }

    @Test
    public void shouldReturn200WhenBookingACabAfterRegistering() {
        Map<String , Location> requestBody = new HashMap<>();
        requestBody.put("pickupLocation" , new Location(-4,6));
        requestBody.put("destinationLocation", new Location(4,6));
        ResponseEntity response = new ResponseEntity(HttpStatus.OK);
        when(cabFacilityController.book(requestBody)).thenReturn(response);
    }

}