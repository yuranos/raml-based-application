package com.yuranos.documented.api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuranos.documented.api.model.Booking;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.ANY)
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookingControllerImplJUnit4Test {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void test1_createBooking() throws Exception {
        Booking booking = new Booking();
        booking.setPassengerName("Bob");
        booking.setPassengerSurname("Whatever");
        booking.setAge(30L);
        booking.setArrivalDate(new Date());
        booking.setDepartureDate(Date.from(LocalDate.now().plusDays(7).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        booking.setDestination("USA");
        mockMvc.perform(
                post("/bookings")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(booking)))
                .andExpect(status().isCreated());
    }

    @Test
    public void test2_getBooking() throws Exception {
        mockMvc.perform(
                get("/bookings/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.passengerName", is("Bob")))
                .andExpect(jsonPath("$.passengerSurname", is("Whatever")));
    }

    @Test
    public void test3_deleteBooking() throws Exception {
        mockMvc.perform(
                delete("/bookings/1")).andExpect(status().isNoContent());
    }

    @Test
    public void test4_getBooking() throws Exception {
        mockMvc.perform(
                get("/bookings/1"))
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString("Such booking doesn’t exist")));
    }

}
