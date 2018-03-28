package com.yuranos.documented.api.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuranos.documented.api.model.Booking;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class BookingServiceImplJUnit5Test {

//    @Autowired
//    MockMvc mockMvc;


    @org.junit.jupiter.api.Test
    void getBooking(@Autowired MockMvc mockMvc) throws Exception {
        String bob = mockMvc.perform(MockMvcRequestBuilders.get("/bookings/5"))
                .andReturn().getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        assertAll("Analyzing Bob's record",
                () -> assertEquals("Bob", objectMapper.readValue(bob, Booking.class).getPassengerName()),
                () -> assertEquals("USA", objectMapper.readValue(bob, Booking.class).getDestination()),
                () -> assertEquals(Double.valueOf(30), objectMapper.readValue(bob, Booking.class).getAge()));
    }

    @org.junit.jupiter.api.Test
    void testException() {
        Executable closureContainingCodeToTest = () -> {throw new ConcurrentModificationException();};

        assertThrows(ConcurrentModificationException.class, closureContainingCodeToTest);
    }

    @org.junit.jupiter.api.Test
    void createBooking() {
    }

    @org.junit.jupiter.api.Test
    void deleteBooking() {
    }

    @org.junit.jupiter.api.Test
    void updateBooking() {
    }

}
