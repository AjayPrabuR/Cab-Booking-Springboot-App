package com.example.cabbooking.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

}