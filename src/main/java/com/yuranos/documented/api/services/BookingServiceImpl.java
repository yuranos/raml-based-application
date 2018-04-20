package com.yuranos.documented.api.services;

import com.yuranos.documented.api.model.BookingEntity;
import com.yuranos.documented.api.repositories.BookingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.function.UnaryOperator;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final UnaryOperator<BookingEntity> bookingEntityUndecorator;
    private final BookingEntityDecoratorImpl bookingEntityDecoratorImpl = new BookingEntityDecoratorImpl();

    @Override
    public BookingEntity getBooking(String bookingId) {
        log.info("Getting Booking with id = {}", bookingId);
        return bookingEntityUndecorator.apply(bookingRepository.findById(Integer.valueOf(bookingId)).orElse(new BookingEntity()));
    }

    @Override
    public BookingEntity createBooking(BookingEntity booking) {
        log.info("Creating Booking ", booking);
        return bookingRepository.save(bookingEntityDecoratorImpl.bookEntityDecorator.apply(booking));
    }

    @Override
    public void deleteBooking(String bookingId) {
        log.info("Deleting Booking with id = {}", bookingId);
        bookingRepository.deleteById(Integer.valueOf(bookingId));
    }

    @Override
    public void updateBooking(String bookingId, BookingEntity booking) {
        log.info("Updating Booking with id = {}", bookingId);
        bookingRepository.update(Integer.valueOf(bookingId), bookingEntityDecoratorImpl.bookEntityDecorator.apply(booking));
    }


}
