package com.yuranos.documented.api.services;

import com.yuranos.documented.api.RamlBasedProducerApplication;
import com.yuranos.documented.api.model.BookingEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import java.util.function.UnaryOperator;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
//@SpringBootTest(classes = RamlBasedProducerApplication.class)
@WebMvcTest
public class BookingServiceImplJUnit4Test {

//    JdbcTestUtils jdbcTestUtils;

    @MockBean
    BookingService bookingService;

    @Test
    public void getBooking() throws Exception {
    }

    @Test
    public void createBooking() throws Exception {
    }

    @Test
    public void deleteBooking() throws Exception {
//        countRowsInTable(..): counts the number of rows in the given table
//
//        countRowsInTableWhere(..): counts the number of rows in the given table, using the provided WHERE clause
//
//        deleteFromTables(..): deletes all rows from the specified tables
//
//        deleteFromTableWhere(..): deletes rows from the given table, using the provided WHERE clause
//
//        dropTables(..): drops the specified tables
    }

    @Test
    public void updateBooking() throws Exception {
    }

}
