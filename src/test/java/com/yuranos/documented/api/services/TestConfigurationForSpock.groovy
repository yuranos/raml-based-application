package com.yuranos.documented.api.services

import com.yuranos.documented.api.model.BookingEntity
import org.springframework.context.annotation.Bean
import spock.mock.DetachedMockFactory

import java.util.function.UnaryOperator

/**
 * A configuration class of mock for the integration test.
 *
 */
//TODO: Check if I need an embedded @TestConfiguration instead
class TestConfigurationForSpock {
    private final detachedMockFactory = new DetachedMockFactory()

    @Bean
    BookingService bookingService() {
        detachedMockFactory.Mock(BookingService);
    }

}
