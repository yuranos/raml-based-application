package com.yuranos.documented.api.services;

import com.yuranos.documented.api.model.BookingEntity;
import com.yuranos.documented.api.repositories.BookingRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    private BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public BookingEntity getBooking(String bookingId) {
        log.info("Getting Booking with id = {}", bookingId);
        return bookingRepository.findById(Integer.valueOf(bookingId)).orElse(new BookingEntity());
    }

    @Override
    public void createBooking(BookingEntity booking) {
        log.info("Creating Booking ", booking);
        bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(String bookingId) {
        log.info("Deleting Booking with id = {}", bookingId);
        bookingRepository.deleteById(Integer.valueOf(bookingId));
    }

    @Override
    public void updateBooking(String bookingId, BookingEntity booking) {
        log.info("Updating Booking with id = {}", bookingId);
        bookingRepository.update(Integer.valueOf(bookingId), booking);
    }
}
