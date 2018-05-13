package com.yuranos.documented.api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuranos.documented.api.model.Booking;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureMockMvc
class BookingControllerImplJUnit5Test {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void testGetBooking() throws Exception {
        String bob = mockMvc.perform(MockMvcRequestBuilders.get("/bookings/1"))
                .andReturn().getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        assertAll("Analyzing Bob's record",
                () -> assertEquals("Bob", objectMapper.readValue(bob, Booking.class).getPassengerName()),
                () -> assertEquals("USA", objectMapper.readValue(bob, Booking.class).getDestination()),
                () -> assertEquals(Long.valueOf(30), objectMapper.readValue(bob, Booking.class).getAge()));
    }
}
