package codility;

import java.util.Arrays;
import java.util.stream.IntStream;

public class GenerateRandomIntArray {
    private static int generateRandomIntegers(int maxLimit) {
        int randomInt = (int) (Math.random() * (maxLimit + 1));
        //int randomInt = (int)Math.ceil(Math.random() * maxLimit);
        return randomInt;
    }
    /**
     * Generates an integer array of non-negative values of length N with values from 0 till maxLimit
     * @param N the length of array to be generated
     * @param maxLimit the max value of any integer in the array
     * @return the array
     */
    public static int[] generateRandomIntArray(int N, int maxLimit) {
        int[] arr = new int[N];
        IntStream.range(0, N)
                .forEach(i -> arr[i] = generateRandomIntegers(maxLimit));
        return arr;
    }

    public static void main(String[] args) {
//        GenerateRandomInts program = new GenerateRandomInts();
//        int[] ints = program.generateRandomIntArray(10, 20);
//        System.out.println(String.format("Array length is %d", ints.length));
//        System.out.println(Arrays.toString(ints));

        System.out.println(Arrays.toString(GenerateRandomIntArray.generateRandomIntArray(10, 20)));

    }
}
