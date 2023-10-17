package map_related.list_to_map;

import org.apache.hadoop.hdfs.web.JsonUtilClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toMap;
import static org.junit.jupiter.api.Assertions.*;

class ListToHashMapTest {

    ListToHashMap listToHashMap;
    List<Person> listOfPerson;


    @BeforeEach
    void setUp() {
        listToHashMap = new ListToHashMap();
        listOfPerson = List.of(
                new Person("Jack", 15),
                new Person("Sara", 20),
                new Person("Bob", 20),
                new Person("Paula", 35),
                new Person("Nancy", 40),
                new Person("Tom", 36),
                new Person("Tom", 70),
                new Person("Bill", 25),
                new Person("Jill", 50),
                new Person("Tom", 60)

        );
    }

    @Test
    void test_nameByAge_should_create_a_map_with_key_as_age_and_value_as_list_of_names() {
        Map<Integer, List<String>> integerStringMap = listToHashMap.namesByAge(listOfPerson);
        integerStringMap.forEach((k,v) -> System.out.println(k + " -> " + v));
    }

    @Test
    void test_nameByAge_should_create_a_map_with_key_as_age_sorted_and_value_as_list_of_names() {
        Map<Integer, List<String>> integerStringMap = listToHashMap.namesByAge(listOfPerson);
        LinkedHashMap<Integer, List<String>> collect = integerStringMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> v2,
                        LinkedHashMap::new
                ));
        collect.forEach((k,v) -> System.out.println(k + " -> " + v));
    }

    @Test
    void test_nameByAge_should_create_a_map_with_key_as_age_sorted_and_value_as_comma_separated_names() {
        Map<Integer, List<String>> integerStringMap = listToHashMap.namesByAge(listOfPerson);
        LinkedHashMap<Integer, String> collect = integerStringMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(toMap(
                        Map.Entry::getKey,
                        e -> String.join(", ", e.getValue()),
                        (v1, v2) -> v2,
                        LinkedHashMap::new
                ));
        collect.forEach((k,v) -> System.out.println(k + " -> " + v));
    }
}