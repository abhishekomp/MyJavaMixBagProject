package java8practice;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class DogDemoGroupingBy {
    public static void main(String[] args) {
        List<Dog> dogList = List.of(
                new Dog("dog1", "German Shepard", 5),
                new Dog("dog2", "Akita Ilu", 10),
                new Dog("dog3", "Akita Ilu", 5),
                new Dog("dog4", "Golden Retriever", 15),
                new Dog("dog5", "Beagle", 8),
                new Dog("dog6", "Beagle", 8)
        );

        //Get all the dogs by their breed and give the dog names per breed in a list
        Map<String, List<String>> dogsNameByBreed = dogList.stream()
                .collect(groupingBy(Dog::getBreed, mapping(Dog::getName, toList())));
        System.out.println("dogsNameByBreed = " + dogsNameByBreed);

        // Get the sum of ages of all the dogs grouped by breed
        Map<String, Integer> totalAgeByBreed = dogList.stream()
                .collect(groupingBy(Dog::getBreed, summingInt(Dog::getAge)));
        System.out.println("totalAgeByBreed = " + totalAgeByBreed);

        // Get the name of the dog with maximum age per breed (we need a map with key as breed and value as the max age in that group)
        Map<String, Optional<Dog>> collect = dogList.stream()
                .collect(groupingBy(Dog::getBreed, maxBy(Comparator.comparingInt(Dog::getAge))));
    }
}
