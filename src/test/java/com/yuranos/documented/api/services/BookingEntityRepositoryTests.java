package com.yuranos.documented.api.services;

import com.yuranos.documented.api.model.BookingEntity;
import com.yuranos.documented.api.repositories.BookingRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class BookingEntityRepositoryTests {

//    @Autowired
//    private TestEntityManager entityManager;

    @Autowired
    private BookingRepository bookingRepository;

//    @Test
//    public void testDelete() throws Exception {
//        this.bookingRepository.deleteById(3);
//        System.out.println(this.bookingRepository.findAll().size());
//    }

    @Test
    public void testCreate() throws Exception {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setDestination("Test");
        bookingEntity.setAge(30d);
        bookingEntity.setArrivalDate(LocalDateTime.now());
        bookingEntity.setDepartureDate(LocalDateTime.now());
        bookingEntity.setPassengerName("Test");
        bookingEntity.setPassengerSurname("Test");
        this.bookingRepository.save(bookingEntity);
    }

    @Test
    public void testUpdate() throws Exception {
        BookingEntity bookingEntity = this.bookingRepository.findById(5).get();
        bookingEntity.setPassengerName("bookingEntity.getPassengerName() + 1");
        this.bookingRepository.save(bookingEntity);
        bookingEntity = this.bookingRepository.findById(5).get();
        System.out.println("Hello");

    }

//    @Test
//    public void testYCreate() throws Exception {
//        BookingEntity bookingEntity = this.bookingRepository.findById(5).get();
//        System.out.println("Hello");
//    }

}
