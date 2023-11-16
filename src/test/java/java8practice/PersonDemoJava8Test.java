package java8practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.stream.Collectors.toMap;
import static org.junit.jupiter.api.Assertions.*;

class PersonDemoJava8Test {

    List<Person> people;

    @BeforeEach
    void setUp(){
        people = List.of(
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

    // create a map from a list using toMap() and use the merge function to resolve the value for the key
    @Test
    void test_creating_a_Map_using_merge() {
//        Map<String, Integer> collect = people.stream()
//                .collect(toMap(Person::getName, Person::getAge));   //java.lang.IllegalStateException: Duplicate key Tom (attempted merging values 60 and 70)
        // Using another flavor of toMap() to resolve the value for the key since there are more than 1 person with same name as key. We need to resolve which age to associate with the key.
        Map<String, Integer> collect = people.stream()
                .collect(toMap(Person::getName, Person::getAge, (age1, age2) -> age1 >= age2 ? age1:age2)); //associate the greater age with the key
        collect.forEach((k,v) -> System.out.println(k + "->" + v));
    }

    // create a map from a list using toMap() and use the merge function to resolve the value for the key and return a map sorted by key
    @Test
    void test_creating_a_Map_using_merge_and_result_a_Map_sorted_by_key() {
    Map<String, Integer> collect = people.stream()
                .collect(toMap(Person::getName, Person::getAge, ((age1, age2) -> age1 >= age2 ? age1:age2), () -> new TreeMap<>(Comparator.naturalOrder()))); //associate the greater age with the key
        // cannot write TreeMap::new as method reference might not take parameters and TreeMap needs to know the comparator as to how to sequence the entries in the map
        // Read: https://stackoverflow.com/questions/44869976/parameters-in-method-reference
        collect.forEach((k,v) -> System.out.println(k + "->" + v));
    }

    // create a map from a list using toMap() and use the merge function to resolve the value for the key and return a map sorted by value
    @Test
    void test_creating_a_Map_using_merge_and_result_a_Map_sorted_by_value() {
//        Map<String, Integer> collect = people.stream()
//                .collect(toMap(Person::getName, Person::getAge, ((age1, age2) -> age1 >= age2 ? age1:age2)))
//                        .entrySet().stream()
//                        .sorted(Comparator.comparingInt(Map.Entry::getValue))
//                                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (val1, val2) -> val1, LinkedHashMap::new));
        // collect = {Jack=15, Bob=20, Sara=20, Bill=25, Paula=35, Nancy=40, Jill=50, Tom=70}

        Map<String, Integer> collect = people.stream()
                .collect(toMap(Person::getName, Person::getAge, ((age1, age2) -> age1 >= age2 ? age1:age2)))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (val1, val2) -> val1, LinkedHashMap::new));
        // collect = {Jack=15, Bob=20, Sara=20, Bill=25, Paula=35, Nancy=40, Jill=50, Tom=70}

        System.out.println("collect = " + collect);
        //collect.forEach((k,v) -> System.out.println(k + "->" + v));
    }
}