package java8practice;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class PersonDemoJava8 {
    //Inspired from: https://www.youtube.com/watch?v=pGroX3gmeP8

    public static List<Person> createPeople() {
        return List.of(
                new Person("Jack", 15),
                new Person("Sara", 20),
                new Person("Bob", 20),
                new Person("Paula", 35),
                new Person("Nancy", 40),
                new Person("Bill", 25),
                new Person("Jill", 50),
                new Person("Tom", 60),
                new Person("Tom", 70)
        );
    }

//    Person jack = new Person("Jack", 15);
//    Person bob = new Person("Bob", 20);
//    Person paula = new Person("Paula", 35);
//    Person nancy = new Person("Nancy", 40);
//    Person bill = new Person("Bill", 25);
//    Person jill = new Person("Jill", 50);
//    Person jillSenior = new Person("Jill", 60);
//
//    static List<Person> persons = List.of(jack, bob, paula, nancy, bill, jill, jillSenior);

    public static void main(String[] args) {
        //convertListToMap(createPeople());
        //getUnModifiableAgeList(createPeople());
        //getCommaSeparatedListOfNamesOlderThan(createPeople(), 30);
        //getListOfEvenAndOddAgedPersons(createPeople());
        //getCountOfPersonsGroupedByName(createPeople());
        //getGroupOfPersonByName(createPeople());   //countByName
        //getGroupOfAgesByName(createPeople());
//        countByNameAsInt(createPeople());
        //getSumOfAges(createPeople());
        //getMaxAge(createPeople());
        //getPersonWithMaxAge(createPeople());    //get the person object
        //getPersonsNameWithMaxAge(createPeople());
        //sortByAge(createPeople());
        //sortByAgeDesc(createPeople());
        //sortByAgeAndThenNameAsc(createPeople());
        //sortByAgeAndGetNames(createPeople());
        //groupByAgeAndGetNames(createPeople());
        getCountByName(createPeople());
    }

    private static void convertListToMap(List<Person> people) {
        Map<String, Integer> nameToAge = people.stream()
                .collect(Collectors.toMap(Person::getName, Person::getAge));
        System.out.println("nameToAge = " + nameToAge);

    }

    private static void groupByAgeAndGetNames(List<Person> people) {
        final Map<Integer, List<String>> collect = people.stream()
                .collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));
        System.out.println("collect = " + collect);
    }

    //Objective: Sort the list of persons according to their age and get the names
    private static void sortByAgeAndGetNames(List<Person> people) {
        people.stream()
                .sorted(comparing(Person::getAge))
                .map(Person::getName)
                .forEach(System.out::println);
    }

    //Objective: Sort the list of person by age in ascending order and if the ages are same then sort those persons by name in ascending order
    private static void sortByAgeAndThenNameAsc(List<Person> people) {
        people.stream()
                //.sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getName))
                .sorted(Comparator.comparingInt(Person::getAge).thenComparing(Person::getName))
                .forEach(System.out::println);
    }

    //Objective: list the persons according to their age in descending order
    private static void sortByAgeDesc(List<Person> people) {
        people.stream()
                //.sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getName))
                .sorted(comparing(Person::getAge).reversed())
                .forEach(System.out::println);
    }

    //Objective: list the persons according to their age in ascending order
    private static void sortByAge(List<Person> people) {
        people.stream()
                .sorted(comparing(Person::getAge))
                .forEach(System.out::println);
    }

    //(Hard) Given a list of person objects (name and age) get the person name having maximum age
    private static void getPersonsNameWithMaxAge(List<Person> people) {
//        Optional<Person> collect = people.stream()
//                .collect(maxBy(comparing(Person::getAge), person -> person.getName()));
        final String name = people.stream()
                .collect(collectingAndThen(maxBy(comparing(Person::getAge)), person -> person.map(Person::getName).orElse("")));
        System.out.println("name = " + name);
    }

    private static void getPersonWithMaxAge(List<Person> people) {
        //final Optional<Person> collect = people.stream().max(comparing(Person::getAge));
        final Optional<Person> collect = people.stream()
                .collect(maxBy(comparing(Person::getAge)));
        System.out.println("collect = " + collect.get());
    }

    private static int getMaxAge(List<Person> people) {
        OptionalInt optionalInt = people.stream()
                .mapToInt(Person::getAge)
                .max();
        return optionalInt.getAsInt();
    }

    private static void getSumOfAges(List<Person> people) {
        final Integer totalAge = people.stream()
                .map(Person::getAge)
                //.reduce(0, (total, age) -> total + age);              //valid
                //.reduce(0, (total, age) -> Integer.sum(total, age));  //valid
                .reduce(0, Integer::sum);                       //valid
        System.out.println("totalAge = " + totalAge);

        //2nd way to calculate sum of ages
        final int totalAge_2ndMethod = people.stream()
                .mapToInt(Person::getAge)
                .sum();
        System.out.println("totalAge_2ndMethod = " + totalAge_2ndMethod);

        final Integer sumOfAges = people.stream()
                .map(Person::getAge)
                .reduce(0, Integer::sum);
        System.out.println("sumOfAges = " + sumOfAges);
    }

    private static void countByNameAsInt(List<Person> people) {
//        final Map<String, Long> countByNameAsInt = people.stream()
//                .collect(Collectors.groupingBy(Person::getName, Collectors.counting()));

        final Map<String, Integer> countByNameAsInt = people.stream()
                .collect(groupingBy(Person::getName, collectingAndThen(counting(), Long::intValue)));
        System.out.println("countByNameAsInt = " + countByNameAsInt);
    }

    // Given a list of persons, give a map that has the key as name of the person and value as count of persons with that name
    private static void getCountByName(List<Person> people) {
        final Map<String, Long> countByName = people.stream()
                .collect(groupingBy(Person::getName, counting()));
        System.out.println("countByName = " + countByName);
    }

    // Given a list of persons, give a map that has the key as name of the person and value as list of (age) of persons
    //groupingBy with Mapping. While groupingBy I don't care about the object. I want to keep the person's age in the named bucket
    //I want to group by name and get the list of ages per group.
    // i.e. If there are 2 persons named Sara in the list then the group named Sara will have 2 ages in the list
    //Here we are grouping by Name but in each bucket we want the age and not the person itself
    // Here we have 3 collectors at work
    // Grouping by assumes that you want a list while mapping asks you to provide that information.
    //Instead of collecting as a list in the value part of the map, we can also mention toSet()
    private static void getGroupOfAgesByName(List<Person> people) {
        final Map<String, List<Integer>> collect = people.stream()
                .collect(groupingBy(Person::getName, mapping(Person::getAge, toList())));
        System.out.println("collect = " + collect);
    }

    // Given a list of persons, give a map that has the key as name of the person and value as list of persons with that name
    private static void getGroupOfPersonByName(List<Person> people) {
        final Map<String, List<Person>> collect = people.stream()
                .collect(Collectors.groupingBy(Person::getName));
        System.out.println("collect = " + collect);
    }

    private static void getCountOfPersonsGroupedByName(List<Person> people) {
        final Map<String, Long> countByName = people.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.counting()));
        System.out.println("countByName = " + countByName);
        //Note that this by default returns Long. But what if you want Int for the count. To get the count as Int we need to do more work. See countByNameAsInt()
    }

    private static void getListOfEvenAndOddAgedPersons(List<Person> people) {
        Map<Boolean, List<Person>> booleanListMap = people.stream()
                .collect(Collectors.partitioningBy(person -> person.getAge() % 2 == 0));
        List<Person> evenAgedList = booleanListMap.get(true);
        List<Person> oddAgedList = booleanListMap.get(false);
        System.out.println("oddAgedList = " + oddAgedList);
        System.out.println("evenAgedList = " + evenAgedList);
    }

    private static void getCommaSeparatedListOfNamesOlderThan(List<Person> people, int age) {
        String collect = people.stream()
                .filter(person -> person.getAge() > 30)
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));
        System.out.println("collect = " + collect);
    }

    private static void getUnModifiableAgeList(List<Person> people) {
        List<Integer> ageList = people.stream()
                .map(Person::getAge)
                .collect(Collectors.toUnmodifiableList());
        //ageList.add(99);
        System.out.println("ageList = " + ageList);
    }
}
