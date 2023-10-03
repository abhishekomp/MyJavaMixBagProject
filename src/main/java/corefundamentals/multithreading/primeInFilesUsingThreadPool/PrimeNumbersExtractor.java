package corefundamentals.multithreading.primeInFilesUsingThreadPool;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;


//This class reads a file which contains Integer on each line and then prepares a list of primes
public class PrimeNumbersExtractor implements Callable<List<Integer>> {
    private final String inFile;

    public PrimeNumbersExtractor(String inFile) {
        this.inFile = inFile;
    }

    @Override
    public List<Integer> call() throws Exception {
        return findPrimes();
    }

    public List<Integer> findPrimes() {
        List<Integer> primeList = new ArrayList<>();
        String line = null;
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(inFile))) {
            Thread.sleep(1000);
            while((line = reader.readLine()) != null) {
                int numToEvaluate = Integer.parseInt(line); //Assumption: Each line in the file has exactly 1 integer
                boolean isPrime = isPrime(numToEvaluate);
                if(isPrime) {
                    primeList.add(numToEvaluate);
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return primeList;
    }

    private boolean isPrime(int numToEvaluate) {
        boolean isPrime = true;

        for(int i = 2; i <= numToEvaluate/2; i++) {
            if(numToEvaluate % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
