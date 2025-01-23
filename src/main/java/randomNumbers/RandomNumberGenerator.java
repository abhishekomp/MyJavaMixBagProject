package randomNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {
    Random randNum;

    public RandomNumberGenerator() {
        randNum = new Random();
        // Note: Specifying a seed will always generate the same sequence of numbers.
        // Use the zero argument constructor without setting a seed value to get a different sequence generated.
        //randNum.setSeed(12345678);
    }

    private int random(int i){
        return randNum.nextInt(i);
    }

    public static List<Integer> getRandomNumbers(int count, int max){
        List<Integer> numbers = new ArrayList<>();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        for(int i = 0; i < count; i++){
            numbers.add(randomNumberGenerator.random(max) + 1);
        }
        return numbers;
    }

    public static void main(String[] args) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            int x = randomNumberGenerator.random(100) + 1;
            //System.out.println(x);
            numbers.add(x);
        }
        numbers.forEach(System.out::println);
    }


}
