package corefundamentals.multithreading.primeInFiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PrimeNumbersExtractor {
    private final String inFile;

    public PrimeNumbersExtractor(String inFile) {
        this.inFile = inFile;
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

    public List<Integer> findPrimesUsingResource() {
        List<Integer> primeList = new ArrayList<>();
        final InputStream inputStream = readResourceAsStream(inFile);
        try(
                InputStreamReader isr = new InputStreamReader(inputStream);
                BufferedReader br = new BufferedReader(isr);) {

            String line = null;
            while((line = br.readLine()) != null) {
                int numToEvaluate = Integer.parseInt(line);
                boolean isPrime = isPrime(numToEvaluate);
                if(isPrime) {
                    primeList.add(numToEvaluate);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return primeList;
    }



    private void printFileContent(InputStream inputStream) {
        try (InputStreamReader streamReader =
                     new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private InputStream readResourceAsStream(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }
}
