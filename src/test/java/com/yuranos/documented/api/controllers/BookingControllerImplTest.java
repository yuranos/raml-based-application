package com.yuranos.documented.api.controllers;

import com.yuranos.documented.api.BookingController;
import com.yuranos.documented.api.services.BookingService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import io.restassured.response.ResponseOptions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@RunWith(SpringRunner.class)
@WebMvcTest(BookingController.class)
abstract public class BookingControllerImplTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ModelMapper modelMapper;

    @MockBean
    private BookingService bookingService;

    @Before
    public void setup() {
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

}
