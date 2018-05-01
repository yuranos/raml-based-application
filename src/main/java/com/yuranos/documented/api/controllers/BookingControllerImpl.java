package com.yuranos.documented.api.controllers;

import com.yuranos.documented.api.BookingController;
import com.yuranos.documented.api.model.Booking;
import com.yuranos.documented.api.model.BookingEntity;
import com.yuranos.documented.api.services.BookingService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@AllArgsConstructor
public class BookingControllerImpl implements BookingController {

    private final BookingService bookingService;

    private final ModelMapper modelMapper;

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    public Booking getBookingById(@PathVariable String bookingId) {
        return convertToDto(bookingService.getBooking(bookingId));
    }

    @Override
    public Object createBooking(@RequestBody Booking booking) {
        Booking createdBooking = convertToDto(bookingService.createBooking(convertToEntity(booking)));
        return ResponseEntity.status(HttpStatus.CREATED).location(addLocation(createdBooking.getId().intValue())).build();
    }

    @Override
    public Object updateBookingById(@PathVariable String bookingId, @RequestBody Booking booking) {
        bookingService.updateBooking(bookingId, convertToEntity(booking));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).location(addLocation(null)).build();
    }

    @Override
    public Object deleteBookingById(@PathVariable String bookingId) {
        bookingService.deleteBooking(bookingId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    private BookingEntity convertToEntity(Booking bookingDto) {
        BookingEntity bookingEntity = modelMapper.map(bookingDto, BookingEntity.class);
        //validate input
        modelMapper.validate();
        return bookingEntity;
    }

    private Booking convertToDto(BookingEntity bookingEntity) {
        return modelMapper.map(bookingEntity, Booking.class);
    }

    private URI addLocation(Integer bookingId) {
        if (bookingId != null) {
            return ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}")
                    .buildAndExpand(bookingId).toUri();
        } else {
            return ServletUriComponentsBuilder
                    .fromCurrentRequest().build().toUri();
        }
    }
}
