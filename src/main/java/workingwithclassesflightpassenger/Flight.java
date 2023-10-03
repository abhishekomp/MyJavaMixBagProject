package workingwithclassesflightpassenger;

import java.util.ArrayList;
import java.util.Iterator;

public class Flight implements Iterable<Passenger>{
    private int passengers;
    private int seats = 150;
    private ArrayList<Passenger> passengerList = new ArrayList<>();

    private int flightNumber;

    public Flight() { }

    public Flight(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void add1Passenger(Passenger p) {
        if(hasSeating()) {
            passengerList.add(p);
            passengers += 1;
        }
    }

    private boolean hasSeating() {
        return passengers < seats;
    }

    @Override
    public Iterator<Passenger> iterator() {
        return passengerList.iterator();
    }
}
