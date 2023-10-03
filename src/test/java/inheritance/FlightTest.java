package inheritance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {

    @Test
    void add1Passenger_to_Flight() {
        Flight flight = new Flight(191, 2);
        flight.add1Passenger();
        flight.add1Passenger();
        flight.add1Passenger();
    }
}