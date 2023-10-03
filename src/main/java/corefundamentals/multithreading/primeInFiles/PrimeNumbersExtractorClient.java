package corefundamentals.multithreading.primeInFiles;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class PrimeNumbersExtractorClient {

    public static void main(String[] args) {
        final Instant startTime = Instant.now();

//        String[] inFiles = {"./file1.txt", "./file2.txt", "./file3.txt"};
        String[] inFiles = {"./file1.txt"};
        List<Integer> finalListOfPrimes = new ArrayList<>();

        for (String inFile : inFiles) {
            PrimeNumbersExtractor primeNumbersExtractor = new PrimeNumbersExtractor(inFile);
            //final List<Integer> primes = primeNumbersExtractor.findPrimes();
            final List<Integer> primes = primeNumbersExtractor.findPrimesUsingResource();
            finalListOfPrimes.addAll(primes);
        }
        final String collect = finalListOfPrimes.stream()
                .map(Object::toString)
                .collect(joining(", "));
        System.out.println("collect = " + collect);

        final Instant endTime = Instant.now();
        System.out.println("Time taken in milli seconds = " + ChronoUnit.MILLIS.between(startTime, endTime));
    }

}
