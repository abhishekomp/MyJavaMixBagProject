package randomNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumbers {
    Random randNum;

    public RandomNumbers() {
        randNum = new Random();
        randNum.setSeed(123456789);
    }

    public int random(int i){
        return randNum.nextInt(i);
    }

    public static void main(String[] args) {
        RandomNumbers randomNumbers = new RandomNumbers();
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            int x = randomNumbers.random(10) + 1;
            //System.out.println(x);
            numbers.add(x);
        }
        numbers.forEach(System.out::println);
    }
}
