package randomNumbers;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class RandomNumberGeneratorTester {
    public static void main(String[] args) {
        List<Integer> numbers = RandomNumberGenerator.getRandomNumbers(20, 10);
        System.out.println(numbers.stream()
                .map(String::valueOf)
                .collect(joining(", ")));
    }
}
