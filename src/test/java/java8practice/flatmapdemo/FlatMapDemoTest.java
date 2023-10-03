package java8practice.flatmapdemo;

import java8practice.personwithhobby.PersonV2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by sca820 on 04 okt., 2022
 */
public class FlatMapDemoTest {

    List<PersonV2> people = asList(
            new PersonV2("Jack", 15, List.of("SINGING", "PAINTING")),
            new PersonV2("Sara", 20, List.of("CHESS", "TRAVELLING")),
            new PersonV2("Bob", 20, List.of("GUITAR", "CHESS")),
            new PersonV2("Paula", 35, List.of("CHESS")),
            new PersonV2("Nancy", 40, List.of("SINGING"))
    );

    @Test
    void fetchPersonWithHobbyAsSinging() {
        people.stream();
    }

    @Test
    void convertStringToUpperCaseStreams() {
        //https://stackoverflow.com/questions/26684562/whats-the-difference-between-map-and-flatmap-methods-in-java-8
        List<String> collected = Stream.of("a", "b", "hello") // Stream of String
                .map(String::toUpperCase) // Returns a stream consisting of the results of applying the given function to the elements of this stream.
                .collect(Collectors.toList());
        assertEquals(asList("A", "B", "HELLO"), collected);
    }

    @Test
    void testFlatMap() throws Exception {
        /*
        In this test method, a Stream of List is passed. It is NOT a Stream of Integer!
        If a transformation Function has to be used (through map), then first the Stream has to be flattened to something else (a Stream of Integer).
        If flatMap is removed then the following error is returned: The operator + is undefined for the argument type(s) List, int.
        It is NOT possible to apply + 1 on a List of Integers!
         */
        List<Integer> together = Stream.of(asList(1, 2), asList(3, 4)) // Stream of List<Integer>
                .flatMap(List::stream)
                .map(integer -> integer + 1)
                .collect(Collectors.toList());
        assertEquals(asList(2, 3, 4, 5), together);
    }

    @Test
    void testFlatMapDemoTwo() {
        /*
        https://medium.com/@jamall.j.brown/java-8-an-in-depth-look-at-map-and-flatmap-b93509ad8661
        Create a list of 3 numbers ([1, 2, 3]), then map each number
        to both its positive and negative number
        values in the output list are: [-1, 1, -2, 2, -3, 3]
         */
        List<Integer> flatMappedList = asList(1, 2, 3)
                .stream()
                .flatMap(value -> Stream.of(-1 * value, value))
                .collect(Collectors.toList());
        assertEquals(asList(-1, 1, -2, 2, -3, 3), flatMappedList);
    }
}
