package com.example.cabbooking.controller;

import com.example.cabbooking.dto.CabBookingRequest;
import com.example.cabbooking.dto.CabRegistrationRequest;
import com.example.cabbooking.model.Location;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(CabFacilityController.class)
class CabFacilityControllerTest {

    @MockBean
    private CabFacilityController cabFacilityController;

    @Test
    public void shouldReturn200AndCabRegisterNumberWhenRegisteringACab() {
        ResponseEntity response = ResponseEntity.ok("Cab registered successfully!!!");
        CabRegistrationRequest request = new CabRegistrationRequest("TN42AF0007", new Location(4,5), "small");
        when(cabFacilityController.register(request)).thenReturn(response);
    }

    @Test
    public void shouldReturn200WhenCabsAreRegistered() {
        CabRegistrationRequest request = new CabRegistrationRequest("TN42AF0007", new Location(4,5), "small");
        cabFacilityController.register(request);
        ResponseEntity response = new ResponseEntity(HttpStatus.OK);
        when(cabFacilityController.status()).thenReturn(response);
    }

    @Test
    public void shouldReturn200WhenBookingACabAfterRegistering() {
        ResponseEntity response = new ResponseEntity(HttpStatus.OK);
        CabBookingRequest request = new CabBookingRequest("small", new Location(4,5), new Location(5,6) );
        when(cabFacilityController.book(request)).thenReturn(response);
    }

}