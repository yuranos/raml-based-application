package com.yuranos.documented.api.controllers

import com.yuranos.documented.api.model.BookingEntity
import com.yuranos.documented.api.services.BookingService
import org.springframework.context.annotation.Bean
import spock.mock.DetachedMockFactory

import java.util.function.UnaryOperator

/**
 * A configuration class of mock for the integration test.
 *
 */
class TestConfigurationForSpock {
    private final detachedMockFactory = new DetachedMockFactory()

    @Bean
    BookingService bookingService() {
        detachedMockFactory.Mock(BookingService);
    }

}
