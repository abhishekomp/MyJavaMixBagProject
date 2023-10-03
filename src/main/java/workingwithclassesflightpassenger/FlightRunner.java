package workingwithclassesflightpassenger;

import java.util.Iterator;

public class FlightRunner {
    public static void main(String[] args) {

        Flight f191 = new Flight(191);
        Passenger p1 = new Passenger("Amit", 1, 90);
        Passenger p2 = new Passenger("Suresh", 2, 80);
        f191.add1Passenger(p1);
        f191.add1Passenger(p2);
        final Iterator<Passenger> passengerIterator = f191.iterator();
        for (Iterator<Passenger> it = passengerIterator; it.hasNext(); ) {
            Passenger p = it.next();
            System.out.println(p.getName());
        }



    }
}
