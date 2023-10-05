package java8practice;

import java8practice.model.product.Product;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

import static org.junit.jupiter.api.Assertions.*;

class Java8LambdaAndStream {

    List<Person> people = List.of(
            new Person("Jack", 15),
            new Person("Sara", 20),
            new Person("Bob", 20),
            new Person("Paula", 20),
            new Person("Nancy", 40),
            new Person("Bill", 20),
            new Person("Jill", 50),
            //new Person("Tom", 60),
            new Person("Tom", 70)
    );

    final List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    //3 apple, 2 banana, others 1
    List<String> fruits =
            Arrays.asList("apple", "apple", "banana",
                    "apple", "orange", "banana", "papaya");

    @Test()
    public void convertListToMap() {
        Map<String, Integer> nameToAge = people.stream()
                .collect(toMap(Person::getName, Person::getAge));
        System.out.println("nameToAge = " + nameToAge);
    }

    @Test
    public void getUnModifiableAgeList() {
        List<Integer> ageList = people.stream()
                .map(Person::getAge)
                .collect(toUnmodifiableList());
        //System.out.println(ageList.getClass().getSimpleName());
        System.out.println(ageList.getClass()); //class java.util.ImmutableCollections$ListN
        //ageList.add(99);    //this will give error java.lang.UnsupportedOperationException because the list is unmodifiable
        System.out.println("ageList = " + ageList);
    }

    @Test
    public void getCommaSeparatedListOfNamesOlderThan() {
        int olderThan = 30;
        String collect = people.stream()
                .filter(person -> person.getAge() > olderThan)
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(joining(", "));
        System.out.println("collect = " + collect);
    }

    @Test
    public void getListOfEvenAndOddAgedPersons() {
        final Map<Boolean, List<Person>> booleanListMap = people.stream()
                .collect(partitioningBy(person -> person.getAge() % 2 == 0));
        //System.out.println("Even aged persons are " + booleanListMap.get(true));
        List<Person> evenAgedList = booleanListMap.get(true);
        List<Person> oddAgedList = booleanListMap.get(false);
        System.out.println("oddAgedList = " + oddAgedList);
        System.out.println("evenAgedList = " + evenAgedList);
    }

    @Test
    public void getListOfNamesOfEvenAndOddAgedPersons() {
        final Map<Boolean, List<String>> booleanListMap = people.stream()
                .collect(partitioningBy(person -> person.getAge() % 2 == 0, mapping(Person::getName, toList())));
        List<String> evenAgedList = booleanListMap.get(true);
        List<String> oddAgedList = booleanListMap.get(false);
        System.out.println("oddAgedNameList = " + oddAgedList);
        System.out.println("evenAgedNameList = " + evenAgedList);
    }

    @Test
    public void getGroupOfPersonByName() {
        final Map<String, List<Person>> groupByName = people.stream()
                .collect(groupingBy(Person::getName));
        System.out.println("groupByName = " + groupByName);
    }

    @Test
    //I want to group by age and get the list of names per group.
    // i.e. If there are 2 persons whose age is 22 then the group named 22 will have 2 names in the list
    //Here we are grouping by Age but in each bucket we want the Name and not the person itself
    public void getGroupByAgeAndGetTheNameListPerGroup() {
        final Map<Integer, List<String>> groupByAge = people.stream()
                .collect(groupingBy(Person::getAge, mapping(Person::getName, toList())));
        System.out.println("groupByAge = " + groupByAge);
    }

    @Test
    //I want to group by age and get the list of names SORTED per group.
    // i.e. If there are 2 persons whose age is 22 then the group named 22 will have 2 names in the list
    //Here we are grouping by Age but in each bucket we want the Name and not the person itself
    //Todo
    public void getGroupByAgeAndGetTheNameListSortedPerGroup() {
        final Map<Integer, List<String>> collect = people.stream()
                //.collect(collectingAndThen(groupingBy(Person::getAge, mapping(Person::getName), toList())))
                .collect(groupingBy(Person::getAge, collectingAndThen(mapping(Person::getName, toList()), l -> l.stream().sorted(Comparator.naturalOrder()).collect(toList()))));
        System.out.println("groupByAge = " + collect);
    }

    @Test
    public void getCountOfPersonsGroupedByName() {
        //people.add(new Person("Tom", 60));
        final Map<String, Long> collect = people.stream()
                .collect(groupingBy(Person::getName, counting()));
        System.out.println("collect = " + collect);
    }

    @Test
    public void shouldConcatenateListOfNumbers() {
        final String concatenatedString = integerList.stream()
                .map(String::valueOf)
                .reduce("", (carry, str) -> carry.concat(str));
        System.out.println("concatenatedString = " + concatenatedString);

        final String finalString = integerList.stream()
                .map(String::valueOf)
                .reduce("", String::concat);
        System.out.println("finalString = " + finalString);
    }

    @Test
    public void givenTheNumberListDoubleTheEvenNumbersAndTotal() {
        final int sum = integerList.stream()
                .filter(e -> e % 2 == 0)
                .mapToInt(e -> e * 2)
                .sum();
        System.out.println("sum = " + sum);

        final Integer sumUsingReduce = integerList.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .reduce(0, Integer::sum);
        System.out.println("sumUsingReduce = " + sumUsingReduce);
    }

    @Test
    public void givenTheNumberListFindTheDoubleOfTheFirstEvenNumberGreaterThan3() {
        final Optional<Integer> first = integerList.stream()
                .filter(e -> e % 2 == 0)
                .filter(e -> e > 3)
                .map(e -> e * 2)
                .findFirst();
        System.out.println("first = " + first);
    }

    @Test
    public void givenAListOfPersonsWithNameAndAgeGetTheSumOfAge() {
        final Integer totalAge = people.stream()
                .map(Person::getAge)
                //.reduce(0, (total, age) -> total + age);
                //.reduce(0, (total, age) -> Integer.sum(total, age));
                .reduce(0, Integer::sum);
        System.out.println("totalAge = " + totalAge);
    }

    @Test
    public void givenAListOfPersonsGetTheListOfNamesInUppercaseOfThoseOlderThan30() {
        final List<String> namesList = people.stream()
                .filter(person -> person.getAge() > 30)
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(toList());


        List<String> namesOlderThan30 = new ArrayList<>();
        people.stream()
                .filter(person -> person.getAge() > 30)
                .map(Person::getName)
                .map(String::toUpperCase)
                //.collect(toList());
                .forEach(name -> namesOlderThan30.add(name));   //DON'T DO THIS. THIS IS SHARED MUTABILITY

        System.out.println("namesList = " + namesList);
    }


    //Given a list of Persons, create a Map with Person’s name as the key and the age as the value
    @Test
    public void givenAListOfPersonsCreateAMapWithNameAsKeyAndAgeAsValue() {
        final Map<String, Integer> mapByNameAndAge = people.stream()
                .collect(toMap(Person::getName, Person::getAge));
        System.out.println("mapByNameAndAge = " + mapByNameAndAge);
    }

    //Group by age and produce a map
    //The key of the map should be the age and value should be name of the person in UPPERCASE with that age
    @Test
    public void groupByAgeAndNameListInUppercase() {
        final Map<Integer, List<String>> collect = people.stream()
                .collect(groupingBy(Person::getAge, mapping(person -> person.getName().toUpperCase(), toList())));  //How to improve this using Method Reference for example
        System.out.println("collect = " + collect);

        final Map<Integer, List<String>> collect2 = people.stream()
                .collect(groupingBy(Person::getAge, mapping(Person::getName, toList())));



//        final String collect1 = people.stream()
//                .collect(collectingAndThen(groupingBy(Person::getAge), personMap -> personMap.values().stream().map()));
//        System.out.println("collect1 = " + collect1);

    }

    @Test
    public void trying_CollectingAndThen_1() {
        final List<String> collect = Stream.of("Hello", "How", "do", "you", "do")
                .collect(collectingAndThen(
                        toList(),
                        Collections::<String>unmodifiableList
                ));
        System.out.println("collect = " + collect);

        assertThrows(UnsupportedOperationException.class, () ->  collect.add("World"));
        //collect.add("World");
    }

    @Test
    //Given a list of fruits as String, create a map with key as fruit name and value as count of that fruit
    public void getMapWithKeyAsFruitnameAndValueAsCount() {
        final Map<String, Long> collect = fruits.stream()
                .collect(groupingBy(Function.identity(), counting()));
        System.out.println("collect = " + collect);
        //{papaya=1, orange=1, banana=2, apple=3}

        //Now get the map with key as fruit name and value as count of that group and the map value should be in descending order i.e. {apple=3, banana=2, orange=1, papaya=1}

    }

    @Test
    public void sortAListOfIntegers() {
        List<Integer> values
                = Arrays.asList(212, 324,
                435, 566,
                133, 100, 121);

//        final List<Integer> collect = values.stream()
//                .sorted()
//                .collect(toList());
//        System.out.println("collect = " + collect);

        values.sort(Comparator.naturalOrder());
        System.out.println("values = " + values);
    }

    @Test
    //Given a list of string, find those strings which appear only once in the list
    public void findDistinctFruitsThatAppearOnlyOnceInList() {
        final List<String> collect = fruits.stream()
                .distinct()
                .collect(toList());
        System.out.println("collect = " + collect);

//        final Map<String, Long> collect1 = fruits.stream()
//                .collect(groupingBy(Function.identity()));
//        System.out.println("collect1 = " + collect1);

        final Map<String, Long> collect1 = fruits.stream()
                .collect(collectingAndThen(groupingBy(Function.identity(), counting()), m -> {
                    m.values().removeIf(v -> v > 1L);
                    return m;
                }));
        System.out.println("collect1 = " + collect1);
    }

    @Test
    //Objective: Given a list of Persons, group them by Age and in the bucket for each group keep only those person's names whose name is more than 3 characters long
    //Imp
    public void groupTheListOfPersonByAgeAndInEachGroupBucketKeepPersonNameWithStringLengthGreaterThan3() {
        System.out.println(people.stream()
                .collect(groupingBy(Person::getAge,
                        mapping(Person::getName, filtering(name -> name.length() > 3, toList())))));
    }

    @Test
    public void findCountOfOccurrenceOfEachCharacterInAString() {
        String str = "banana";

        final Map<String, Long> collect = Arrays.stream(str.split(""))
                .collect(groupingBy(Function.identity(), counting()));
        System.out.println("collect = " + collect);

    }

    @Test
    public void allMatch_should_return_true_when_all_elementss_match_the_predicate() {
        final boolean b = people.stream()
                .allMatch(person -> person.getAge() > 50);
        System.out.println("b = " + b);

        final boolean allMatch = people.stream()
                .filter(person -> person.getAge() > 100)
                .allMatch(person -> person.getName().startsWith("K"));
        System.out.println("allMatch = " + allMatch);
    }

    @Test
    public void perform_sum_of_ages() {
        final int sum = people.stream()
                .mapToInt(Person::getAge)
                .sum();
        System.out.println("sum = " + sum);
    }

    @Test
    //Let’s say we have a comma-separated string of numbers. Without having to write many lines of code, we can get a list of numbers as per our example.
    //https://theoneamin.medium.com/useful-java-streams-d48266effe59
    public void convert_commaseparated_to_list() {
        String numbers = "1,2,3,4,5";
        final List<Integer> collect = Stream.of(numbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());
        System.out.println("collect = " + collect);
    }

    @Test
    //https://stackoverflow.com/questions/51403058/intstream-map-function-behavior
    //https://docs.google.com/document/d/1eEv8JMCr_ZBoE5JSsZxdT5Zq53vq388-EIbE_mi7QME/edit  ApnaCollege
    public void givenAListOfIntegersGetTheCountOfPositiveNegativeAndZero() {
        final List<Integer> integers = List.of(1, 2, 3, 4, -5, -6, -7, 0, 0, 10);
        final Map<Integer, Long> collect = integers.stream()
                .collect(groupingBy(Integer::signum, counting()));
        System.out.println("collect = " + collect);
    }

    @Test
    //Increment each letter of a String
    public void ForAStringIncrementEachCharacter() {
        String str = "HELLO";   //IFMMP
        str.chars()
                .map(e -> e + 1)
                .mapToObj(e -> (char) e)
                .forEach(System.out::print);

    }

    @Test
    //List the first letter of each word from a sentence
    public void ListTheFirstLetterOfEachWord() {
        String str = "Hello World How are you"; //H, W
        Arrays.stream(str.split(" "))
                .map(e -> e.charAt(0))
                .forEach(System.out::println);
    }

    @Test
    public void tryingPeekMethod() {
//        Stream.of("One", "Two", "Three", "Four")
//                .peek(e -> e.toUpperCase())
//                .forEach(System.out::println);
//
//        people.stream()
//                .peek(e -> e.setName(e.getName().toUpperCase()))
//                .forEach(System.out::println);

        final List<String> collect = Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(toList());

        Stream.iterate(100000000000000L, n -> n + 37)
                .limit(10)
                .forEach(System.out::println);
    }

    //Filter Map
    @Test
    void filterAMap() {
        Map<String, Long> skuCodeByCount = Product.skuCodeByCount();
        final Map<String, Long> filteredSkuCodeByCount = skuCodeByCount.entrySet().stream()
                .filter(e -> e.getValue() > 100L)
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));
        filteredSkuCodeByCount.forEach((k,v) -> System.out.println(k + " -> " + v));
    }

    @Test
    public void try_stream_linkedin_20230318() {
        //Question: Get the average of a list of numbers after squaring them and filtering out any that are bigger than 100
        //https://www.linkedin.com/feed/update/urn:li:activity:7042758509695823872?utm_source=share&utm_medium=member_desktop
        List<Integer> integers = Arrays.asList(1, 7, 8, 9, 5, 2);
        final double average = integers.stream()
                .map(i -> i * i)
                .filter(i -> i <= 100)
                .mapToInt(i -> i)
                .average()
                .getAsDouble();
        System.out.println("average = " + average);
    }

    /**
     * Take a sentence as input and sort the words in it by the number of
     * times they appear in the sentence. In the case of a tie, the words
     * should be sorted alphabetically.
     * To do (2023-10-03)
     */
    @Test
    public void test_groupBy_map_key_sort_it_collect_the_sorted_keys_in_a_list() {
        String input = "The bear quick bear brown dog jumps over the lazy dog";

        List<Map.Entry<String, Long>> collect = Arrays.stream(input.split("\\s+"))
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(toList());
        System.out.println("collect = " + collect);


        Map<String, List<String>> collect1 = Arrays.stream(input.split("\\s+"))
                .collect(groupingBy(Function.identity()));
        System.out.println("collect1 = " + collect1);

    }

    // Find the longest word from a given sentence. Pre Java 8 way
    @Test
    public void test_should_give_the_longest_word_from_the_sentence() {
        String sentence = "The quick Dinosauraus brown fox jumps over the lazy dog and pink pig";

        //Extract all the words from the sentence
        String[] words = sentence.split("\\s+");
        int prevWordLength = 0;
        String longestWord = "";
        for(String word : words) {
            int currentWordLength = word.length();
            if(currentWordLength > prevWordLength) {
                prevWordLength = currentWordLength;
                longestWord = word;
            }
        }
        System.out.println("longestWord = " + longestWord);
    }

    // Find the longest word from a given sentence. Pre Java 8 way
    @Test
    public void test_should_give_the_longest_word_from_the_sentence_Java8() {
        String sentence = "The quick Dinosauraus brown fox jumps over the lazy dog and pink pig";

        //Extract all the words from the sentence
        String[] words = sentence.split("\\s+");
        List<String> list = Arrays.asList(words);
        Map<String, Integer> wordToLength = list.stream()
                        .collect(toMap(Function.identity(),String::length));
        System.out.println("wordToLength = " + wordToLength);

        // Extracting the longest word from a sentence.
        Optional<String> longestWord = list.stream().max(comparing(String::length));
        System.out.println("longestWord = " + longestWord.get());
    }

    @Test
    @Disabled
    public void abc() {

    }
}