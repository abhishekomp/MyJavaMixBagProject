package java8practice.personwithhobby;

import org.junit.jupiter.api.Test;

import java.util.*;


import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    List<Person> people = Arrays.asList(
            new Person("Jack", 15,  List.of(Hobby.SINGING, Hobby.PAINTING)),
            new Person("Sara", 20,  List.of(Hobby.CHESS, Hobby.TRAVELLING)),
            new Person("Bob", 20,   List.of(Hobby.GUITAR, Hobby.CHESS)),
            new Person("Paula", 35, List.of(Hobby.CHESS)),
            new Person("Nancy", 40, List.of(Hobby.CHESS)),
            new Person("Matt", 50, List.of(Hobby.PAINTING)),
            new Person("Pippi", 10)
    );

    @Test
    //For the list of persons with a list of hobbies as enum, get the list of all hobbies they have (this list will have duplicates)
    //Done
    public void shouldGetListOfHobbiesForAllThePersons() {
        List<Hobby> collect = people.stream()
                .flatMap(e -> e.getHobbies().stream())
                .collect(toList());
        System.out.println("List of hobbies(duplicates) = " + collect);
    }

    @Test
    //For the list of persons with a list of hobbies, get the list of all UNIQUE hobbies they have
    //Done
    public void shouldGetListOfUniqueHobbiesForAllThePersons() {
        Set<Hobby> collect = people.stream()
                .flatMap(e -> e.getHobbies().stream())
                .collect(toSet());
        System.out.println("List of hobbies(unique) = " + collect);
    }

    @Test
    //For the list of persons with a list of hobbies, get the person names in uppercase that have hobby as Chess
    //Done
    public void shouldGetPersonNamesInUpperCaseHavingHobbyAsChess() {
        List<String> collect = people.stream()
                .filter(e -> e.getHobbies().contains(Hobby.CHESS))
                .map(e -> e.getName().toUpperCase())
                .collect(toList());
        System.out.println("collect = " + collect);
    }

    @Test
    //For the list of persons with a list of hobbies, get the person names in uppercase that have more than 1 hobby
    //Done
    public void shouldGetPersonNamesInUpperCaseHavingMoreThan1Hobby() {
        List<String> collect = people.stream()
                .filter(e -> e.getHobbies().size() > 1)
                .map(e -> e.getName().toUpperCase())
                .collect(toList());
        System.out.println("collect = " + collect);
    }

    //Done
    //For the list of persons with a list of hobbies, get the person names in uppercase that have exactly 2 hobbies
    @Test
    public void shouldGetPersonNamesInUpperCaseHavingExactlyTwoHobbies() {
        List<String> collect = people.stream()
                .filter(e -> e.getHobbies().size() == 2)
                .map(e -> e.getName().toUpperCase())
                .collect(toList());
        System.out.println("collect = " + collect);
    }

    @Test
    //For the list of persons with a list of hobbies, get the person names in uppercase that have no hobby
    //Done
    public void shouldGetPersonNamesInUpperCaseHavingNoHobby() {
        List<String> collect = people.stream()
                .filter(e -> e.getHobbies().size() == 0)
                .map(e -> e.getName().toUpperCase())
                .collect(toList());
        System.out.println("collect = " + collect);
    }

    @Test
    //For the list of persons with a list of hobbies, get the person objects that have no hobby
    //Done
    public void shouldGetPersonObjectsHavingNoHobby() {
        List<Person> collect = people.stream()
                .filter(e -> e.getHobbies().size() == 0)
                .collect(toList());
        System.out.println("collect = " + collect);
    }

    @Test
    //For the list of persons with a list of hobbies, get the person names in uppercase sorted in Ascending Order that have more than 1 hobby
    //Done
    public void shouldGetPersonNamesInAscendingOrderInUpperCaseHavingMoreThan1Hobby() {
        List<String> collect = people.stream()
                .filter(e -> e.getHobbies().size() > 1)
                .map(e -> e.getName().toUpperCase())
                .sorted()
                .collect(toList());

        System.out.println("collect = " + collect);
    }

    @Test
    //For the list of persons with a list of hobbies, get the person names in uppercase sorted in Descending Order that have more than 1 hobby
    //Done
    public void shouldGetPersonNamesInDescendingOrderInUpperCaseHavingMoreThan1Hobby() {
        List<String> collect = people.stream()
                .filter(e -> e.getHobbies().size() > 1)
                .map(e -> e.getName().toUpperCase())
                .sorted(Comparator.reverseOrder())
                .collect(toList());

        System.out.println("collect = " + collect);
    }

    @Test
    //For the list of persons with a list of hobbies, get a comma separated list of person names in uppercase sorted in Ascending Order that have more than 1 hobby
    //Done
    public void shouldGetCommaSeparatedPersonNamesInAscendingOrderInUpperCaseHavingMoreThan1Hobby() {
        String collect = people.stream()
                .filter(e -> e.getHobbies().size() > 1)
                .map(e -> e.getName().toUpperCase())
                .sorted()
                .collect(joining(", "));
        System.out.println("collect = " + collect);
    }

    @Test
    //For the list of persons with a list of hobbies, create a map with key as hobby and value as list of person names with that hobby
    //For the list of persons with a list of hobbies, create a map with key as hobby and value as list of person names in SORTED Order for that hobby.
    //https://stackoverflow.com/questions/36850855/java-stream-group-by-when-key-appears-in-a-list
    //https://stackoverflow.com/questions/29567575/sort-map-by-value-using-lambdas-and-streams
    //https://www.baeldung.com/java-map-entry
    //https://www.baeldung.com/java-maps-streams
    //Output: {SINGING=[JACK], GUITAR=[BOB], CHESS=[BOB, NANCY, PAULA, SARA], PAINTING=[JACK], TRAVELLING=[SARA]}
    //Done
    //VERY IMP
    public void createAMapWithKeyAsHobbyAndValueAsListOfPersonsWithThatHobby() {
        final Map<Enum, List<String>> collect = people.stream()
                .flatMap(person -> person.getHobbies().stream().map(hobby -> new AbstractMap.SimpleEntry<>(hobby, person.getName().toUpperCase())))
                //.flatMap(person -> person.getHobbies().stream().map(hobby -> new AbstractMap.SimpleEntry<Enum, String>(hobby, person.getName().toUpperCase())))
                //.flatMap(person -> person.getHobbies().stream().map(hobby -> new AbstractMap.SimpleEntry<>(hobby, person)))
                .sorted(Map.Entry.comparingByValue())
                .collect(groupingBy(Map.Entry::getKey, mapping(Map.Entry::getValue, toList())));
                //.collect(groupingBy(Map.Entry::getKey);
        System.out.println("collect = " + collect);
    }

    @Test
    //For the list of persons with a list of hobbies, create a map with key as such hobbies which has more than 1 person and value as List of person names in SORTED ORDER
    //https://stackoverflow.com/questions/36261036/implementation-of-having-count-with-group-by-in-java-8
    //Sorting a map (Sort a map)
    //Map sorting
    //Done
    //VERY IMP
    public void createAMapWithKeyAsHobbyWhichIsPersuedByMoreThan1PersonAndValueAsListOfPersonName() {
        final Map<Hobby, List<String>> collect = people.stream()
                .flatMap(person -> person.getHobbies().stream().map(hobby -> new AbstractMap.SimpleEntry<>(hobby, person.getName())))
                .sorted(Map.Entry.comparingByValue())
                .collect(collectingAndThen(groupingBy(Map.Entry::getKey, mapping(Map.Entry::getValue, toList())), m -> {
                    m.values().removeIf(l -> l.size() <= 1);
                    return m;
                }));
        System.out.println("collect = " + collect);
    }

    @Test
    //For the list of persons with a list of hobbies, create a map with key as hobby and value as count of Persons with that hobby
    //collect = {TRAVELLING=1, SINGING=1, GUITAR=1, CHESS=4, PAINTING=1}
    //Done
    public void createAMapWithKeyAsHobbyAndValueAsCountOfPersonsWithThatHobby() {
        final Map<Hobby, Long> collect = people.stream()
                .flatMap(person -> person.getHobbies().stream().map(hobby -> new AbstractMap.SimpleEntry<>(hobby, person)))
                .collect(groupingBy(Map.Entry::getKey, counting()));
        System.out.println("collect = " + collect);
    }

    @Test
    //For the list of persons with a list of hobbies, create a map with key as such hobbies which has more than 1 person and value count of persons for that hobby
    //https://stackoverflow.com/questions/36261036/implementation-of-having-count-with-group-by-in-java-8
    //Done
    public void createAMapWithKeyAsHobbyWhichIsPersuedByMoreThan1PersonAndValueAsCountForThatHobby() {
        final Map<Hobby, Long> collect = people.stream()
                .flatMap(person -> person.getHobbies().stream().map(hobby -> new AbstractMap.SimpleEntry<>(hobby, person)))
                .collect(collectingAndThen(groupingBy(Map.Entry::getKey, counting()), m -> {
                    m.values().removeIf(v -> v <= 1L);
                    return m;
                }));
        System.out.println("collect = " + collect);
    }
}