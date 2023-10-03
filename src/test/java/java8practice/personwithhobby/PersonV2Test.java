package java8practice.personwithhobby;

import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.*;

class PersonV2Test {
    List<PersonV2> people = Arrays.asList(
            new PersonV2("Jack", 15, List.of("SINGING", "PAINTING")),
            new PersonV2("Sara", 20, List.of("CHESS", "TRAVELLING")),
            new PersonV2("Bob", 20, List.of("GUITAR", "CHESS")),
            new PersonV2("Paula", 35, List.of("CHESS")),
            new PersonV2("Nancy", 40, List.of("CHESS"))
    );

    @Test
    //For a list of Person, create a map with key as hobby and value as list of person with that hobby
    //This gives a map with key as a List and value as List of Persons but we need the key to be the hobby name and value equal to the list of person with that hobby
    public void createAMapWithKeyAsHobbyAndValueAsListOfPersonsWithThatHobby() {
        final Map<List<String>, List<PersonV2>> collect = people.stream()
                .collect(groupingBy(PersonV2::getHobbies));
        System.out.println("collect = " + collect);
    }

    @Test
    //For a list of Person, create a map with key as hobby and value as list of person with that hobby
    //https://stackoverflow.com/questions/36850855/java-stream-group-by-when-key-appears-in-a-list
    public void createAMapWithKeyAsHobbyAndValueAsListOfPersonsWithThatHobbyV2() {
        final Map<String, List<PersonV2>> collect = people.stream()
                .flatMap(person -> person.getHobbies().stream().map(hobby -> new AbstractMap.SimpleEntry<>(hobby, person)))
                .collect(groupingBy(Map.Entry::getKey, mapping(Map.Entry::getValue, toList())));
        System.out.println("collect = " + collect);
    }

    @Test
    //For a list of Person, create a map with key as hobby and value as list of person with that hobby
    //https://stackoverflow.com/questions/36850855/java-stream-group-by-when-key-appears-in-a-list
    public void createAMapWithKeyAsHobbyAndValueAsListOfPersonNamesWithThatHobby() {
        final Map<String, List<String>> collect = people.stream()
                .flatMap(person -> person.getHobbies().stream().map(hobby -> new AbstractMap.SimpleEntry<>(hobby, person.getName())))
                .collect(groupingBy(Map.Entry::getKey, mapping(Map.Entry::getValue, toList())));
        System.out.println("collect = " + collect);
        //Output: collect = {SINGING=[Jack], CHESS=[Sara, Bob, Paula, Nancy], GUITAR=[Bob], PAINTING=[Jack], TRAVELLING=[Sara]}
    }

    @Test
    //For a list of Person, create a map with key as hobby and value as list of person names in sorted order with that hobby
    //Done
    //https://stackoverflow.com/questions/29567575/sort-map-by-value-using-lambdas-and-streams
    public void createAMapWithKeyAsHobbyAndValueAsListOfPersonNamesInSortedOrderWithThatHobby() {
        final Map<String, List<String>> collect = people.stream()
                .flatMap(person -> person.getHobbies().stream().map(hobby -> new AbstractMap.SimpleEntry<>(hobby, person.getName())))
                .sorted(Map.Entry.<String, String>comparingByValue())
                .collect(groupingBy(Map.Entry::getKey, mapping(Map.Entry::getValue, toList())));
        System.out.println("collect = " + collect);
        //Output: collect = {SINGING=[Jack], CHESS=[Bob, Nancy, Paula, Sara], GUITAR=[Bob], PAINTING=[Jack], TRAVELLING=[Sara]}
    }

}