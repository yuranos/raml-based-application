package com.yuranos.documented.api.services

import groovy.json.JsonSlurper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import spock.lang.Specification
import static org.springframework.http.HttpStatus.OK

@AutoConfigureMockMvc
@SpringBootTest
class BookingServiceImplSpockTest extends Specification {

    @Autowired
    MockMvc mockMvc;

    def "should fetch Bob and Alice without errors"() {
        given:
        def response = mockMvc.perform(MockMvcRequestBuilders.get("/bookings/$id")).andReturn().response
        def content = new JsonSlurper().parseText(response.contentAsString)

        expect:
        response.status == OK.value()

        and:
        content.passengerName == result

        where:
        id    || result
        '5'   || "Bob"
        '15'  || "Alice"
    }



//    def "GetBooking"() {
//        given:
//        whatever
//    }
//
//    def "CreateBooking"() {
//    }
//
//    def "DeleteBooking"() {
//    }
//
//    def "UpdateBooking"() {
//    }
//
//    def setup() {}          // run before every feature method
//    def cleanup() {}        // run after every feature method
//    def setupSpec() {}     // run before the first feature method
//    def cleanupSpec() {}   // run after the last feature method
}
