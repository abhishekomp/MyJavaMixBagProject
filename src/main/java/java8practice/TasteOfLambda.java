package java8practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TasteOfLambda {

    static List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public static void main(String[] args) {
        //doubleAllEvenAndGetTotal(numbers);
        //productInfiniteStream();
        //findNextNNumbers();

        createAListOfIntegerGivenTheBoundaries(21,30);
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

    private static List<Integer> createAListOfIntegerGivenTheBoundaries(int start, int end) {
        int limit = end - start + 1;
        final List<Integer> integers = Stream.iterate(start, e -> e + 1)
                .limit(limit)
                .collect(Collectors.toList());
        integers.forEach(System.out::println);
        return integers;
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
