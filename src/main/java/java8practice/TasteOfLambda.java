package java8practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class TasteOfLambda {

    static List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public static void main(String[] args) {
        //doubleAllEvenAndGetTotal(numbers);
        //productInfiniteStream();
        //findNextNNumbers();

        //createAListOfIntegerGivenTheBoundaries(21,30);
    }

    //Given a number k, and a count n, find the total of the double of n even numbers starting with k, where square root of each number is greater than 20
    private static void findNextNNumbers() {
        int k = 121;
        int n = 51;
        System.out.println(Stream.iterate(k, e -> e + 1)
                .filter(e -> e % 2 == 0)
                .filter(e -> Math.sqrt(e) > 20)
                .mapToInt(e -> e * 2)
                .limit(n)
                .sum());
    }

    private static void productInfiniteStream() {
        Stream.iterate(100, e -> e + 1);
        System.out.println(Stream.iterate(100, e -> e + 1));
    }

    /**
     * Generate a list of Integers given the start and end element
     * @param start Integer to begin with
     * @param end Integer to end with
     * @return  the list containing the integers
     */
    List<Integer> createAListOfIntegerGivenTheBoundaries(int start, int end) {
        int limit = end - start + 1;
        final List<Integer> integers = Stream.iterate(start, e -> e + 1)
                .limit(limit)
                .collect(toList());
        //integers.forEach(System.out::println);
        return integers;
    }

    /**
     * Starting from the given odd number gets next N odd numbers
     * @param start the starting odd number
     * @param count the number of next numbers
     * @return a list of numbers
     */
    List<Integer> getNextNOddNumbers(int start, int count) {
        //Assuming that the value of start is an odd number
        List<Integer> oddNumbers = Stream.iterate(start, e -> e + 2)
                .limit(count)
                .collect(toList());
        return oddNumbers;
    }

    /**
     * Get the first N elements from a list
     * @param inputList the list
     * @param count the number of elements to get from the list
     * @return a sub-list with count number of elements
     */
    List<Integer> getFirstNElements(List<Integer> inputList, int count) {
        int from = 0;
        List<Integer> list = inputList.subList(from, count);
        return list;
    }

    private static void doubleAllEvenAndGetTotal(List<Integer> numbers) {
        final Optional<Integer> reduce = numbers.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .reduce(Integer::sum);

        final int sum = numbers.stream()
                .filter(e -> e % 2 == 0)
                .mapToInt(e -> e * 2)
                .sum();

        System.out.println("sum = " + sum);
        System.out.println("reduce = " + reduce);

        final Integer reduce1 = numbers.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .reduce(0, (e, total) -> e + total);
        System.out.println("reduce1 = " + reduce1);
    }
}
