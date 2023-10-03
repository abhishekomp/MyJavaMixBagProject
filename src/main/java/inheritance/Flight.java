package inheritance;

public class Flight {
    int flightNumber;
    int seats;
    int passengerCount;

    public Flight() {
        //no-arg default Constructor
    }

    public Flight(int flightNumber, int seats) {
        this.flightNumber = flightNumber;
        this.seats = seats;
        this.passengerCount = 0;
    }

    public void add1Passenger() {
        if(hasSeating()) {
            passengerCount++;
            System.out.println("Seats available = " + seats);
            System.out.println("1 passenger added. PassengerCount = " + passengerCount);
        }
        else {
            hasNoSeats();
        }
    }

    private void hasNoSeats() {
        System.out.println("No seats available");
    }

    private boolean hasSeating() {
        return seats > passengerCount;
    }
}
