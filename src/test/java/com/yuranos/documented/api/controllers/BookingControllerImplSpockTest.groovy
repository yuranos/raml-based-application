package com.yuranos.documented.api.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.yuranos.documented.api.model.Booking
import groovy.json.JsonSlurper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import spock.lang.Stepwise

import java.time.LocalDate
import java.time.ZoneId

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.ANY)
@Stepwise
class BookingControllerImplSpockTest extends Specification {

    @Autowired
    MockMvc mockMvc

    @Autowired
    ObjectMapper objectMapper

    def "should create a booking"() {
        given:
            Booking booking = new Booking();
            booking.setPassengerName("Bob");
            booking.setPassengerSurname("Whatever");
            booking.setAge(30L);
            booking.setArrivalDate(new Date());
            booking.setDepartureDate(Date.from(LocalDate.now().plusDays(7).atStartOfDay(ZoneId.systemDefault()).toInstant()))
            booking.setDestination("USA");
            def result = mockMvc.perform(post("/bookings").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(booking))).andReturn()

        expect:
            result.response.status == HttpStatus.CREATED.value()

    }

    def "should get a booking"() {
        given:
            def result = mockMvc.perform(
                get("/bookings/$id")).andReturn()
            def content = new JsonSlurper().parseText(result.response.contentAsString)

        expect:
            result.response.status == HttpStatus.OK.value()
            content.passengerName == name
            content.passengerSurname == surname

        where:
            id    || name  || surname
            '1'   || "Bob" || "Whatever"
    }

    def "should delete a booking"() {
        given:
            def result = mockMvc.perform(
                delete("/bookings/1")).andReturn()

        expect:
            result.response.status == HttpStatus.NO_CONTENT.value()
    }


    def "should not be able to get a deleted booking"() {
        given:
            def result = mockMvc.perform(
                    get("/bookings/1")).andReturn()

        expect:
            result.response.status == HttpStatus.NOT_FOUND.value()
            result.response.contentAsString == "Such booking doesn’t exist"
    }
}
