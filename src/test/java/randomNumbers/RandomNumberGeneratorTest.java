package randomNumbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.stream.Collectors.joining;

class RandomNumberGeneratorTest {

    RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    void setUp() {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @Test
    void getRandomNumbers() {
        List<Integer> randomNumbers = RandomNumberGenerator.getRandomNumbers(20, 10);
        //randomNumbers.forEach(System.out::println);
        String collect = randomNumbers.stream()
                .map(String::valueOf)
                .collect(joining(", "));
        System.out.println(collect);
    }
}