package com.yuranos.documented.api.services;

import com.yuranos.documented.api.model.BookingEntity;

public interface BookingService {

    BookingEntity getBooking(String bookingId);
    BookingEntity createBooking(BookingEntity booking);
    void deleteBooking(String bookingId);
    void updateBooking(String bookingId, BookingEntity booking);
}
