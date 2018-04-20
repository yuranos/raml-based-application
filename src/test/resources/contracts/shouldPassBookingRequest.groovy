package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'PUT'
        url '/bookings/4'
        body("""
{
    "id": 4,
    "destination": "USA",
    "departureDate": "2018-05-28T13:00:56Z",
    "arrivalDate": "2018-02-28T12:42:17Z",
    "passengerName": "James",
    "passengerSurname": "Bond",
    "age": 30
}
    """)
        headers {
            header('Content-Type', 'application/json')
        }
    }
    response {
        status 204
    }
}
