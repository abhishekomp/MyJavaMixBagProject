package inheritance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CargoFlightTest {

    @Test
    void add1Package() {
        Flight f = new CargoFlight(12);
        f.add1Passenger();
    }
}