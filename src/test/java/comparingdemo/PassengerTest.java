package comparingdemo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class PassengerTest {

    @Test
    void compare_Passenger_using_memberLevel() {
        final List<Passenger> passengers = new ArrayList<>(Passenger.getPassengers());
        Collections.reverse(passengers);
        System.out.println("Passenger sorted by member level");
        passengers.stream().forEach(System.out::println);
        assertThat(passengers.get(0).getName()).isEqualTo("Amit");
    }

    @Test
    void compare_Passenger_using_memberLevelV2() {
        final List<Passenger> passengers = new ArrayList<>(Passenger.getPassengers());
        System.out.println("Passenger before sort");
        passengers.stream().forEach(System.out::println);
        //Collections.sort(passengers);
        Collections.sort(passengers,Collections.reverseOrder());
        System.out.println("Passenger sorted by member level");
        passengers.stream().forEach(System.out::println);
        assertThat(passengers.get(0).getName()).isEqualTo("Amit");
    }

    @Test
    void compare_Passenger_using_memberLevel_Using_Comparing() {
        final List<Passenger> passengers = new ArrayList<>(Passenger.getPassengers());
        passengers.sort(
                Comparator.comparing(Passenger::getMemberLevel).thenComparing(Passenger::getMemberDays)
        );
        System.out.println("Passenger sorted by member level");
        passengers.stream().forEach(System.out::println);
        assertThat(passengers.get(0).getName()).isEqualTo("Amit");
    }

    @Test
    void compare_Passenger_using_memberLevel_Using_Comparing_reversed() {
        final List<Passenger> passengers = new ArrayList<>(Passenger.getPassengers());
        System.out.println("Passenger before sort");
        passengers.stream().forEach(System.out::println);
        passengers.sort(
                Comparator.comparing(Passenger::getMemberLevel).thenComparing(Passenger::getMemberDays).reversed()
        );
        System.out.println("Passenger sorted by member level");
        passengers.stream().forEach(System.out::println);
        assertThat(passengers.get(0).getName()).isEqualTo("Harish");
    }

    @Test
    void compare_Passenger_using_memberLevel_Using_ComparingV2() {
        final List<Passenger> passengers = new ArrayList<>(Passenger.getPassengers());
        System.out.println("Passenger before sort");
        passengers.stream().forEach(System.out::println);
        passengers.sort(
                Comparator.comparing(Passenger::getMemberLevel)
        );
        System.out.println("Passenger sorted by member level");
        passengers.stream().forEach(System.out::println);
        assertThat(passengers.get(0).getName()).isEqualTo("Harish");
    }
}