package com.yuranos.documented.api.services;

import com.yuranos.documented.api.model.BookingEntity;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.UnaryOperator;

@Getter
@Setter
@Service
public class BookingEntityDecoratorImpl {
    final UnaryOperator<BookingEntity> bookEntityDecorator = (bookingEntity) -> {
        bookingEntity.setDestination(Optional.of(bookingEntity.getDestination()).orElse("") + " (Provided by Thomas Cook)");
        return bookingEntity;
    };
}
