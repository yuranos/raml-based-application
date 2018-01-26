package com.yuranos.documented.api.services;

import com.yuranos.documented.api.model.Booking;
import com.yuranos.documented.api.model.BookingEntity;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {

    BookingEntity getBooking(String bookingId);
    void createBooking(BookingEntity booking);
    void deleteBooking(String bookingId);
    void updateBooking(String bookingId, BookingEntity booking);
}
