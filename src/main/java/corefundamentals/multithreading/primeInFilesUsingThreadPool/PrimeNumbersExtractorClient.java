package corefundamentals.multithreading.primeInFilesUsingThreadPool;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static java.util.stream.Collectors.joining;

public class PrimeNumbersExtractorClient {

    public static void main(String[] args) {
        final Instant startTime = Instant.now();

        String[] inFiles = {"./file1.txt", "./file2.txt", "./file3.txt"};
        List<Integer> finalListOfPrimes = new ArrayList<>();

        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<List<Integer>>[] results = new Future[inFiles.length];

        for (int i = 0; i < inFiles.length; i++) {
            PrimeNumbersExtractor primeNumbersExtractor = new PrimeNumbersExtractor(inFiles[i]);
            results[i] = es.submit(primeNumbersExtractor);
        }

        for(Future<List<Integer>> result : results) {
            try {
                List<Integer> primes = result.get();
                finalListOfPrimes.addAll(primes);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }


        try {
            es.shutdown();
            es.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        final String collect = finalListOfPrimes.stream()
                .map(Object::toString)
                .collect(joining(", "));
        System.out.println("collect = " + collect);

        final Instant endTime = Instant.now();
        System.out.println("Time taken in milli seconds = " + ChronoUnit.MILLIS.between(startTime, endTime));
    }

}
