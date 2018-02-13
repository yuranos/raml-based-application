package com.yuranos.documented.api.services;

import com.yuranos.documented.api.model.BookingEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.function.UnaryOperator;

@Service
public class BookingEntityUndecoratorImpl implements UnaryOperator<BookingEntity> {

    @Override
    public BookingEntity apply(BookingEntity bookingEntity) {
        bookingEntity.setDestination(StringUtils.remove(bookingEntity.getDestination(), " (Provided by Thomas Cook)"));
        return bookingEntity;
    }
}
