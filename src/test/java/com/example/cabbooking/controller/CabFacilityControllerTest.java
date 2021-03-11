package com.example.cabbooking.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@RunWith(SpringRunner.class)
@WebMvcTest(CabFacilityController.class)
class CabFacilityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CabFacilityController cabFacilityController;

    @Test
    public void shouldReturn200WhenRegisteringAllCabs() throws Exception {
        ResponseEntity response = new ResponseEntity(HttpStatus.OK);
        when(cabFacilityController.register()).thenReturn(response);
        this.mockMvc.perform(put("/cab/register")).andExpect(status().isOk());
    }

    @Test
    public void shouldReturn400WhenCabsAreNotRegistered() throws Exception {
        ResponseEntity response = new ResponseEntity(HttpStatus.BAD_REQUEST);
        when(cabFacilityController.status()).thenReturn(response);
        this.mockMvc.perform(get("/cab/status")).andExpect(status().isBadRequest());
    }


    @Test
    public void shouldReturn200WhenBookingACabAfterRegistering() throws Exception {
        ResponseEntity response = new ResponseEntity(HttpStatus.OK);
        when(cabFacilityController.register()).thenReturn(response);
        this.mockMvc.perform(put("/cab/register")).andExpect(status().isOk());

        ResponseEntity response_Check = new ResponseEntity("{ pickupLocation: {x:-4,y: 6}, destinationLocation: { x:4 , y:6}}", HttpStatus.OK);

        mockMvc.perform(
                put("/cab/book/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"pickupLocation\" :{ \"x\" :-4, \"y\" :6}, \"destinationLocation\": { \"x\":4, \"y\":6} }"));

        when(cabFacilityController.status()).thenReturn(response_Check);
        this.mockMvc.perform(get("/cab/status/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("{ pickupLocation: {x:-4,y: 6}, destinationLocation: { x:4 , y:6}}")));
    }

}